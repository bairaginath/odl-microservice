#!/bin/bash

if [ $# -eq 0 ]; then
    COUNTER=1
fi

if [ $# -eq 1 ]
then
    COUNTER=$1
fi

if [ $# -gt 1 ]; then
    echo "Usage: spawn_router.sh <no of devices>"
    exit 0
fi

for ITERATION in `eval "echo {1..$COUNTER}"`
do
    PORTNUMBER=`cat .ids`

    ######## Spin up containers
    DEVICE_NAME="router"$PORTNUMBER
    sudo docker rm -f $DEVICE_NAME
    DOCKER_ID=`sudo docker run -p $PORTNUMBER:830  --name $DEVICE_NAME -dit sdnhub/netopeer /bin/bash`
    echo $DOCKER_ID
    echo "Spawned container with IP `sudo docker inspect --format '{{ .NetworkSettings.IPAddress }}' $DEVICE_NAME`"

    echo "DeviceName: $DEVICE_NAME, PORTNUMBER: $PORTNUMBER"

    PORTNUMBER=`expr $PORTNUMBER + 1`
    echo  $PORTNUMBER > .ids

    ######## Start netconf server with custom YANG model
    sudo cp base_datastore.xml /var/lib/docker/aufs/mnt/${DOCKER_ID}/usr/local/etc/netopeer/cfgnetopeer/datastore.xml
    sudo cp router.yang /var/lib/docker/aufs/mnt/${DOCKER_ID}/root/router.yang
    sudo docker exec $DEVICE_NAME pyang -f yin /root/router.yang -o /root/router.yin
    sudo docker exec $DEVICE_NAME netopeer-manager add --name router --model router.yin --datastore /usr/local/etc/netopeer/cfgnetopeer/router.xml
    sudo docker exec $DEVICE_NAME netopeer-server -d
done
