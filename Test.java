import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testCreate() {
        Kulig ob1 = new Kulig("Marcin","22","ss");
        Assert.assertEquals("Marcin",ob1.getDriver());

    }
    @org.junit.Test
    public void shouldReturnMirek(){
        Kulig ob2 = new Kulig("aa", "bb","cc","Mirek","normal", 20,5000);
        Assert.assertEquals("Mirek",ob2.getHorseName());
    }

     @org.junit.Test
    public void shouldReturnABC(){
         Kulig tab[] = {new Kulig("b","s","ss"), new Kulig("c","s","ss"), new Kulig("a","s","ss")};
         Arrays.sort(tab, new MyComparator());
         Assert.assertEquals("a", tab[0].getDriver());
         Assert.assertEquals("b", tab[1].getDriver());
         Assert.assertEquals("c", tab[2].getDriver());
     }

}
