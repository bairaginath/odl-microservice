#!/bin/bash
if [ $# -ne 2 ]
then
    echo "Usage: spawn_router <device-name>"
    exit 0
fi

######## Spin up containers
DEVICE_NAME=$1
sudo docker rm -f $DEVICE_NAME
DOCKER_ID=`sudo docker run -p $2:830  --name $DEVICE_NAME -dit sdnhub/netopeer /bin/bash`
DOCKER_ID=${DOCKER_ID:0:12}
echo $DOCKER_ID
echo "Spawned container with IP `sudo docker inspect --format '{{ .NetworkSettings.IPAddress }}' $DEVICE_NAME`"

######## Start netconf server with custom YANG model
#sudo cp base_datastore.xml /var/lib/docker/aufs/mnt/${DOCKER_ID}/usr/local/etc/netopeer/cfgnetopeer/datastore.xml
sudo docker cp base_datastore.xml ${DOCKER_ID}:/usr/local/etc/netopeer/cfgnetopeer/datastore.xml
sudo docker cp router.yang ${DOCKER_ID}:/root/router.yang
sudo docker exec $DEVICE_NAME pyang -f yin /root/router.yang -o /root/router.yin
sudo docker exec $DEVICE_NAME netopeer-manager add --name router --model router.yin --datastore /usr/local/etc/netopeer/cfgnetopeer/router.xml
sudo docker exec $DEVICE_NAME netopeer-server -d

