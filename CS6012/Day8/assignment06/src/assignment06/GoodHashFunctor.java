package assignment06;

public class GoodHashFunctor implements HashFunctor {
    @Override
    public int hash(String item) {
        int hash = 0;
        for(int i=0; i< item.length();i++){
          hash = hash*23 +item.charAt(i);
        }

        return Math.abs(hash);
    }
}
