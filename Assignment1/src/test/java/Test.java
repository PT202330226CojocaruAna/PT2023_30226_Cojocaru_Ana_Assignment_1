public class Test {

    @Test
    public void testInmultire (){

        Polinom polinom1= new Polinom("3x^2+2x");
        Polinom polinom2= new Polinom("2x");
        Polinom result= Operatii.Inmultire(polinom1, polinom2);

        Polinom rez= new Polinom("6x^3+4x^2");

        assertEquals(result, rez);
    }

}
