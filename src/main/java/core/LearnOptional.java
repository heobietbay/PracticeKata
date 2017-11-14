package core;

import core.model.Computer;
import core.model.ComputerV2;

import java.util.Optional;

public class LearnOptional {
    public static void main(String[] args) {
        System.out.println("\n---------DEMO WITHOUT OPTIONAL---------");
        withoutOptionalDemo();

        System.out.println("\n---------DEMO WITH OPTIONAL---------");
        withOptionalDemo();
    }

    private static void withoutOptionalDemo() {
        Computer computer = new Computer();
        computer.setSoundCard(new Computer.SoundCard());

        // get computer usb version - WITHOUT NULL CHECK
        // String version = computer.getSoundCard().getUsb().getVersion();
        String version = "UNKNOWN";
        Computer.SoundCard soundcard = computer.getSoundCard();
        if(soundcard != null){
            Computer.Usb usb = soundcard.getUsb();
            if(usb != null){
                version = usb.getVersion();
            }
        }
        System.out.println(version);
    }

    private static void withOptionalDemo(){
        ComputerV2 computerV2 = new ComputerV2();

        // Creating optional object
        computerV2.setSoundCard(Optional.empty());
        //1.Adopting Optional
        String version = computerV2.getSoundCard()
                                   .flatMap(ComputerV2.SoundCard::getUsb) //flatMap ensures that an Optional<Usb> is returned instead of an Optional<Optional<Usb>>
                                   .map(ComputerV2.Usb::getVersion)
                                   .orElse("UNKNOWN") ;
        System.out.println(version);

        // notice in this version, I use a combination of map + orElse to replace flatMap, for demonstration purpose
        version = computerV2.getSoundCard()
                .map(ComputerV2.SoundCard::getUsb)
                .orElse(Optional.empty())
                .map(ComputerV2.Usb::getVersion)
                .orElse("UNKNOWN") ;
        System.out.println(version);

        //2.Do Something If a Value Is Present
        computerV2.getSoundCard().ifPresent(soundCard -> System.out.println(soundCard));
         // Print something when soundcard is present
        computerV2.setSoundCard(Optional.of(new ComputerV2.SoundCard()));
        computerV2.getSoundCard().ifPresent(soundCard -> System.out.println("Have sound card"));
    }
}
