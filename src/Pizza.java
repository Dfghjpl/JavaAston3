import java.util.Objects;

public class Pizza {

    private final Size size;
    private final boolean cheese;
    private final boolean bacon;
    private final boolean onions;
    private final boolean pineapple;
    private final boolean olives;
    private final boolean tomato;


    private Pizza(Bilder bilder) {
        this.size = bilder.size;
        this.cheese = bilder.chesse;
        this.bacon = bilder.bacon;
        this.onions = bilder.onions;
        this.pineapple = bilder.pineapple;
        this.olives = bilder.olives;
        this.tomato = bilder.tomato;
    }

    public Size getSize() {
        return size;
    }

    public boolean getChesse() {
        return cheese;
    }

    public boolean getBacon() {
        return bacon;
    }

    public boolean getOnions() {
        return onions;
    }

    public boolean getPineapple() {
        return pineapple;
    }

    public boolean getOlives() {
        return olives;
    }

    public boolean getTomato() {
        return tomato;
    }

    public static class Bilder {
        private final Size size;

        private boolean chesse = false;
        private boolean cheese = false;
        private boolean bacon = false;
        private boolean onions = false;
        private boolean pineapple = false;
        private boolean olives = false;
        private boolean tomato = false;

        public Bilder(Size size) {
            this.size = size;
        }

        public Bilder chesse() {
            this.chesse = true;
            return this;
        }

        public Bilder bacon() {
            this.bacon = true;
            return this;
        }

        public Bilder onions() {
            this.onions = true;
            return this;
        }

        public Bilder pineapple() {
            this.pineapple = true;
            return this;
        }

        public Bilder olives() {
            this.olives = true;
            return this;
        }

        public Bilder tomato() {
            this.tomato = true;
            return this;
        }

        public Pizza bild() {
            return new Pizza(this);
        }

    }

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE;
    }

    @Override
    public String toString() {
        return String.format("Пицца размера:%s Наполнение: сыр=%s, бекон=%s, лук=%s, ананасы=%s, оливки=%s, помидоры=%s",
                size, cheese, bacon, onions, pineapple, olives, tomato);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null)||(getClass() != obj.getClass())) return false;

        Pizza pizza=(Pizza) obj;
        return size==pizza.size&&
                cheese==pizza.cheese&&
                bacon==pizza.bacon&&
                onions==pizza.onions&&
                pineapple==pizza.pineapple&&
                olives==pizza.olives&&
                tomato==pizza.tomato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size,cheese,bacon,onions,pineapple,olives,tomato);
    }
}
