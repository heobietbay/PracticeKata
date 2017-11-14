package core.model;

public class Computer {


    /**
     * Getter.
     *
     * @return soundCard
     */
    public SoundCard getSoundCard() {
        return soundCard;
    }

    /**
     * Setter.
     *
     * @param soundCard soundCard
     */
    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }
    private SoundCard soundCard;

    public static class SoundCard {
        /**
         * Getter.
         *
         * @return usb
         */
        public Usb getUsb() {
            return usb;
        }

        /**
         * Setter.
         *
         * @param usb usb
         */
        public void setUsb(Usb usb) {
            this.usb = usb;
        }

        private Usb usb;

    }

    public static class Usb {
        /**
         * Getter.
         *
         * @return version
         */
        public String getVersion() {
            return version;
        }

        /**
         * Setter.
         *
         * @param version version
         */
        public void setVersion(String version) {
            this.version = version;
        }

        private String version;
    }
}
