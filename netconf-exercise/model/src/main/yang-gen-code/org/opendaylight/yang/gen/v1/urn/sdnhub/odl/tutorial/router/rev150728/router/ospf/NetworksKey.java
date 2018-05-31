package org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.ospf;
import org.opendaylight.yangtools.yang.binding.Identifier;
import java.util.Objects;


public class NetworksKey
 implements Identifier<Networks> {
    private static final long serialVersionUID = 8572042825438103441L;
    private final java.lang.String _subnetIp;


    public NetworksKey(java.lang.String _subnetIp) {
    
    
        this._subnetIp = _subnetIp;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public NetworksKey(NetworksKey source) {
        this._subnetIp = source._subnetIp;
    }


    public java.lang.String getSubnetIp() {
        return _subnetIp;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(_subnetIp);
        return result;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NetworksKey other = (NetworksKey) obj;
        if (!Objects.equals(_subnetIp, other._subnetIp)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.ospf.NetworksKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_subnetIp != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_subnetIp=");
            builder.append(_subnetIp);
         }
        return builder.append(']').toString();
    }
}

