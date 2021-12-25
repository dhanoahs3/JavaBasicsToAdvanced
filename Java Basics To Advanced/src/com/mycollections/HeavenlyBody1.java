package com.mycollections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/*Instead of using Constants which are private static final we can use enum which are
* collections of Constant
*
* Please note how we use Bodytypes instead of enum
* in the given method      public HeavenlyBody1(String name, double orbitalPeriod,BodyTypes bodyType)
*
* Also we define a empty enum as this
*     private final BodyTypes bodyType;
* All this is because when we define enum ,we define it as a type .Here BodyType is actually a type and
* not a name. For example for int i = 10  ,i is a name of type integer
* but here "BodyType" is a new type and NOT a name for type enum
*     public enum BodyTypes{ }
*
*
* Please note that we have removed name and bodyType members from our class HeavenlyBody.
* instead what we have done is we defined a inner class called Key and defined name and bodyType there
 And in the same inner class we have over riden the equals and hashCode methods so that we can compare
 * if two key objects are equal based on name and bodyType
 * And so for members of outer class HeavenlyBody all we have to do is define a member of type Key(the
 * inner class) and in the constructor we initiate an object of the class Key
 *             this.key = new Key(name,bodyType);
*/
public abstract class HeavenlyBody1 {
    private final Key key;
    private final  double orbitalPeriod;
    private final Set<com.mycollections.HeavenlyBody1> satellites ;


    /*public static final int STAR = 2;
    public static final int PLANET = 2;*/

    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }


 /*Also note here in constructor we are passing argumment of type BodyTypes and when we call this constructor
 * anywhere in out subclasses we will provide an actual value like MOON ,COMET etc as an argument and then
 * for that particular sub class object the value of bodyType would be the same like MOON etc.
 * We pass the value for type enum  like this to constructor
 * Another thing to note is for enums its compile time checking that is if we pass anything like this
 *         super(name, orbitalPeriod,BodyTypes.DWARF_PLANEffsssssssss);
 to the constructor an error will be thrown becuse DWArf_Planetssssssssss is not there in enum BodyTpes.
 *  {
        super(name, orbitalPeriod,BodyTypes.PLANET);
    }
    * And then we can check something like this
    *   public boolean addSatellite(HeavenlyBody1 moon) {
     //   if(moon.getBodyType() ==BodyTypes.MOON)
     * */
    public HeavenlyBody1(String name, double orbitalPeriod,BodyTypes bodyType) {
            this.key = new Key(name,bodyType);
            this.orbitalPeriod = orbitalPeriod;
            this.satellites = new HashSet<>();
        }


        public double getOrbitalPeriod() {
            return orbitalPeriod;
        }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody1 moon){
            return this.satellites.add(moon);
        }

        public Set<com.mycollections.HeavenlyBody1> getSatellites(){
            return new HashSet<com.mycollections.HeavenlyBody1>(this.satellites);
        }

    public static Key makeKey(String name ,BodyTypes bodyTpe){
        return new Key(name,bodyTpe);
    }

    @Override
        public final boolean equals(Object obj) {
            if (this == obj) return true;
            /*Here what we did is check if obj is an instance of Heavenly body
            * And since we did instance check we don't have to do something like this
            * if(obj==null||obj.getClass()!=this.getClass())
            return false;*/
            if(obj instanceof HeavenlyBody1){
                /*So all we do is this i.e check based on the class members we want.
                * in our case we are comparing based on member Key and Key is an inner class
                * with members name and bodyType and also has its own over riden methods equals and
                * hashcode to compare two key objects*/
                HeavenlyBody1 theObject = (HeavenlyBody1) obj;
                //pass the HeavenlyBody object to equals method in key to compare.
                //then call the equals method in the keys class of the Heavenly body
                //i.e first check if object is instance og heavenly body
                //then use equals method of Key class using this and pass key of obj to it as argument
                //using theObject.getKey.
               return this.key.equals(theObject.getKey());
            }
                return false;
        }

     @Override
     public final int hashCode() {
         return this.key.hashCode();
        }


    @Override
    public String toString() {
        return this.key.name + " : " + this.key.bodyType + " , "+this.orbitalPeriod;
    }

  public static final class Key{
        private String name;
        private BodyTypes bodyType;

      private Key(String name, BodyTypes bodyType) {
          this.name = name;
          this.bodyType = bodyType;
      }

      public String getName() {
          return name;
      }

      public BodyTypes getBodyType() {
          return bodyType;
      }

      @Override
      public boolean equals(Object obj) {
          Key key = (Key)obj;
          if(this.name.equals(key.getName())){
              return this.bodyType.equals(key.getBodyType());
          }
         return false;
      }

      @Override
      public int hashCode() {
          return this.name.hashCode()+57+this.bodyType.hashCode();
      }

      @Override
      public String toString() {
          return this.name + " : "+ this.bodyType;
      }
  }

}

