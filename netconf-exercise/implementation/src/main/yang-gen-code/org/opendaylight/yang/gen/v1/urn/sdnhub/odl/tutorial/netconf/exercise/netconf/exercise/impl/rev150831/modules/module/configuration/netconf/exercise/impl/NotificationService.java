package org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.netconf.exercise.netconf.exercise.impl.rev150831.modules.module.configuration.netconf.exercise.impl;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.Module;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceRef;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * <p>This class represents the following YANG schema fragment defined in module <b>netconf-exercise-impl</b>
 * <br>(Source path: <i>META-INF/yang/netconf-exercise.yang</i>):
 * <pre>
 * container notification-service {
 *     leaf type {
 *         type leafref;
 *     }
 *     leaf name {
 *         type leafref;
 *     }
 *     uses service-ref {
 *         refine (urn:sdnhub:odl:tutorial:netconf-exercise:netconf-exercise-impl?revision=2015-08-31)type {
 *             leaf type {
 *                 type leafref;
 *             }
 *         }
 *     }
 * }
 * </pre>
 * The schema path to identify an instance is
 * <i>netconf-exercise-impl/modules/module/configuration/(urn:sdnhub:odl:tutorial:netconf-exercise:netconf-exercise-impl?revision=2015-08-31)netconf-exercise-impl/notification-service</i>
 *
 * <p>To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.netconf.exercise.netconf.exercise.impl.rev150831.modules.module.configuration.netconf.exercise.impl.NotificationServiceBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.netconf.exercise.netconf.exercise.impl.rev150831.modules.module.configuration.netconf.exercise.impl.NotificationServiceBuilder
 *
 */
public interface NotificationService
    extends
    ChildOf<Module>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.netconf.exercise.netconf.exercise.impl.rev150831.modules.module.configuration.netconf.exercise.impl.NotificationService>,
    ServiceRef
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.create("urn:sdnhub:odl:tutorial:netconf-exercise:netconf-exercise-impl",
        "2015-08-31", "notification-service").intern();


}

