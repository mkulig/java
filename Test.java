import org.junit.Assert;

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
}
