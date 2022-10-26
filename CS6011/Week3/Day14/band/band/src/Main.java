import java.util.ArrayList;

interface Instrument{
    public void play();
    //public void tune();
    public void playloud(boolean loud);

}
 class trumpet implements Instrument {
     boolean loud_ = false;

     @Override
     public void play() {
         System.out.println("toot toot");

     }


     @Override
     public void playloud(boolean loud) {
         loud_ = loud;

     }
 }
 class Drums implements Instrument{
        boolean loud_ = true;
         @Override
         public void play() {
             System.out.println("rat----");
         }

         @Override
         public void playloud(boolean loud) {

             return ;
         }
     }
     class ElectricPiano implements Instrument{
        boolean loud_ = false;
        boolean on_ = false;
        public void turnOn( boolean on){
        on_ = on;

        }

         @Override
         public void play() {
             if (on_){
             System.out.println("ab-cd- da");
             }
             else{
                 System.out.println("......");
             }
        }
             public void playloud(boolean loud){
                 return;
             }

         }


  class Band{
    String name_ ;
    ArrayList<Instrument> instruments_ = new ArrayList<Instrument>();
    public Band(String name){
        name_ = name;
    }
//    public void addInstrument(Object trump){
//    instruments_.add( trump );
// }
    public void addInstrument(Instrument inst){
        instruments_.add(inst);
    }

     public void play() {
        for( Instrument i : instruments_) {
            if (i instanceof ElectricPiano) {
                ((ElectricPiano) i).turnOn(true);
            }
        }
        System.out.println("Band play:");
         for ( Instrument i: instruments_){
             i.play();
         }
     }
 }
 class ConcertHall {
        Band currentBand_;
        public void bookBand(Band theBand ){
        currentBand_ = theBand;
 }
 public void startConcert(){
    if( currentBand_== null){
    System.out.println("No band is booked, concert cancelled");
    }
    else {currentBand_.play();
    }
     }
         }
public class Main {
    public static void main(String[] args) {

        trumpet trump1 = new trumpet();
        Drums drum1 = new Drums();
        Instrument piano = new ElectricPiano();
//piano.turnOn( ture );
//        piano.play();

        Band gband = new Band("my Band");
        gband.addInstrument( trump1);
        gband.addInstrument( drum1 );
        gband.addInstrument( piano );

        gband.play();

        ConcertHall hall = new ConcertHall();
//
        hall.startConcert();

    }
}