package org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.bgp;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>router</b>
 * <br>(Source path: <i>META-INF/yang/router.yang</i>):
 * <pre>
 * list neighbors {
 *     key "as-number"
 *     leaf as-number {
 *         type uint32;
 *     }
 *     leaf peer-ip {
 *         type string;
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>router/router/bgp/neighbors</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.bgp.NeighborsBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.bgp.NeighborsBuilder
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.bgp.NeighborsKey
 *
 */
public interface Neighbors
    extends
    ChildOf<Bgp>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.bgp.Neighbors>,
    Identifiable<NeighborsKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:odl:tutorial:router",
        "2015-07-28", "neighbors").intern();

    java.lang.Long getAsNumber();
    
    java.lang.String getPeerIp();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    NeighborsKey getKey();

}

