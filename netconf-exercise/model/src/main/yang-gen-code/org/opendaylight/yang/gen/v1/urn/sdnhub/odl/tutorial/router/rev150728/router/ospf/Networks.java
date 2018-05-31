package org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.ospf;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Ospf;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>router</b>
 * <br>(Source path: <i>META-INF/yang/router.yang</i>):
 * <pre>
 * list networks {
 *     key "subnet-ip"
 *     leaf subnet-ip {
 *         type string;
 *     }
 *     leaf area-id {
 *         type uint32;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>router/router/ospf/networks</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.ospf.NetworksBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.ospf.NetworksBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.ospf.NetworksKey
 *
 */
public interface Networks
    extends
    ChildOf<Ospf>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.ospf.Networks>,
    Identifiable<NetworksKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:odl:tutorial:router",
        "2015-07-28", "networks").intern();

    java.lang.String getSubnetIp();
    
    java.lang.Long getAreaId();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    NetworksKey getKey();

}

