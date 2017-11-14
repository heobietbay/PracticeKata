package core.model;

import java.util.Optional;

public class ComputerV2 {

    /**
     * Getter.
     *
     * @return soundCard
     */
    public Optional<SoundCard> getSoundCard() {
        return soundCard;
    }

    /**
     * Setter.
     *
     * @param soundCard soundCard
     */
    public void setSoundCard(Optional<SoundCard> soundCard) {
        this.soundCard = soundCard;
    }

    private Optional<SoundCard> soundCard;

    public static class SoundCard {

        /**
         * Getter.
         *
         * @return usb
         */
        public Optional<Usb> getUsb() {
            return usb;
        }

        /**
         * Setter.
         *
         * @param usb usb
         */
        public void setUsb(Optional<Usb> usb) {
            this.usb = usb;
        }

        private Optional<Usb> usb;

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
