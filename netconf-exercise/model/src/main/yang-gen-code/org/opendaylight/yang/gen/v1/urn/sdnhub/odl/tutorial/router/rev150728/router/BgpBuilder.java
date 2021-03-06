package org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.bgp.Neighbors;
import java.util.Objects;
import java.util.List;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp} instances.
 *
 * @see org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp
 *
 */
public class BgpBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp> {

    private java.lang.Long _asNumber;
    private BgpKey _key;
    private List<Neighbors> _neighbors;
    private java.lang.String _routerId;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>> augmentation = Collections.emptyMap();

    public BgpBuilder() {
    }

    public BgpBuilder(Bgp base) {
        if (base.getKey() == null) {
            this._key = new BgpKey(
                base.getAsNumber()
            );
            this._asNumber = base.getAsNumber();
        } else {
            this._key = base.getKey();
            this._asNumber = _key.getAsNumber();
        }
        this._neighbors = base.getNeighbors();
        this._routerId = base.getRouterId();
        if (base instanceof BgpImpl) {
            BgpImpl impl = (BgpImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.Long getAsNumber() {
        return _asNumber;
    }
    
    public BgpKey getKey() {
        return _key;
    }
    
    public List<Neighbors> getNeighbors() {
        return _neighbors;
    }
    
    public java.lang.String getRouterId() {
        return _routerId;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

     
     private static void checkAsNumberRange(final long value) {
         if (value >= 0L && value <= 4294967295L) {
             return;
         }
         throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0‥4294967295]].", value));
     }
    
    public BgpBuilder setAsNumber(final java.lang.Long value) {
    if (value != null) {
        checkAsNumberRange(value);
    }
        this._asNumber = value;
        return this;
    }
    
     
    public BgpBuilder setKey(final BgpKey value) {
        this._key = value;
        return this;
    }
    
     
    public BgpBuilder setNeighbors(final List<Neighbors> value) {
        this._neighbors = value;
        return this;
    }
    
     
    public BgpBuilder setRouterId(final java.lang.String value) {
        this._routerId = value;
        return this;
    }
    
    public BgpBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public BgpBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Bgp build() {
        return new BgpImpl(this);
    }

    private static final class BgpImpl implements Bgp {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp.class;
        }

        private final java.lang.Long _asNumber;
        private final BgpKey _key;
        private final List<Neighbors> _neighbors;
        private final java.lang.String _routerId;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>> augmentation = Collections.emptyMap();

        private BgpImpl(BgpBuilder base) {
            if (base.getKey() == null) {
                this._key = new BgpKey(
                    base.getAsNumber()
                );
                this._asNumber = base.getAsNumber();
            } else {
                this._key = base.getKey();
                this._asNumber = _key.getAsNumber();
            }
            this._neighbors = base.getNeighbors();
            this._routerId = base.getRouterId();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.Long getAsNumber() {
            return _asNumber;
        }
        
        @Override
        public BgpKey getKey() {
            return _key;
        }
        
        @Override
        public List<Neighbors> getNeighbors() {
            return _neighbors;
        }
        
        @Override
        public java.lang.String getRouterId() {
            return _routerId;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        private int hash = 0;
        private volatile boolean hashValid = false;
        
        @Override
        public int hashCode() {
            if (hashValid) {
                return hash;
            }
        
            final int prime = 31;
            int result = 1;
            result = prime * result + Objects.hashCode(_asNumber);
            result = prime * result + Objects.hashCode(_key);
            result = prime * result + Objects.hashCode(_neighbors);
            result = prime * result + Objects.hashCode(_routerId);
            result = prime * result + Objects.hashCode(augmentation);
        
            hash = result;
            hashValid = true;
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp other = (org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp)obj;
            if (!Objects.equals(_asNumber, other.getAsNumber())) {
                return false;
            }
            if (!Objects.equals(_key, other.getKey())) {
                return false;
            }
            if (!Objects.equals(_neighbors, other.getNeighbors())) {
                return false;
            }
            if (!Objects.equals(_routerId, other.getRouterId())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                BgpImpl otherImpl = (BgpImpl) obj;
                if (!Objects.equals(augmentation, otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>>, Augmentation<org.opendaylight.yang.gen.v1.urn.sdnhub.odl.tutorial.router.rev150728.router.Bgp>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Bgp [");
            boolean first = true;
        
            if (_asNumber != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_asNumber=");
                builder.append(_asNumber);
             }
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_neighbors != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_neighbors=");
                builder.append(_neighbors);
             }
            if (_routerId != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_routerId=");
                builder.append(_routerId);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
