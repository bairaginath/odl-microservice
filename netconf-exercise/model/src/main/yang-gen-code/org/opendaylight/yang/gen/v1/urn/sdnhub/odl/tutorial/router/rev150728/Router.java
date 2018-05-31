package org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Ospf;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>router</b>
 * <br>(Source path: <i>META-INF/yang/router.yang</i>):
 * <pre>
 * container router {
 *     list ospf {
 *         key "process-id"
 *         leaf process-id {
 *             type uint32;
 *         }
 *         list networks {
 *             key "subnet-ip"
 *             leaf subnet-ip {
 *                 type string;
 *             }
 *             leaf area-id {
 *                 type uint32;
 *             }
 *         }
 *     }
 *     list bgp {
 *         key "as-number"
 *         leaf as-number {
 *             type uint32;
 *         }
 *         leaf router-id {
 *             type string;
 *         }
 *         list neighbors {
 *             key "as-number"
 *             leaf as-number {
 *                 type uint32;
 *             }
 *             leaf peer-ip {
 *                 type string;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>router/router</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.RouterBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.RouterBuilder
 *
 */
public interface Router
    extends
    ChildOf<RouterData>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.Router>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:odl:tutorial:router",
        "2015-07-28", "router").intern();

    List<Ospf> getOspf();
    
    List<Bgp> getBgp();

}

