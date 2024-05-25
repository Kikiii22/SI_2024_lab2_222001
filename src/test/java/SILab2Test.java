import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class SILab2Test {

    @Test
    public void TestForEveryBranch()
    {
        ////allitems=null, payment=*,Exception "allItems list can't be null!"
        Exception exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!",exception.getMessage());

        ////allitems={item11},payment=*,item1={null,null,35,35}
       Item item11=new Item("", null,35, 0.5F);
       List<Item>lista =new ArrayList<>();
       lista.add(item11);
       Exception exceptionn = assertThrows(RuntimeException.class, () -> SILab2.checkCart(lista, 100));
       assertEquals("No barcode!",exceptionn.getMessage());

      ////allitems={item1},payment=*,item1={null,-1511,22,35},item2={kika,1111,22,33}
        Item item1=new Item("","-1511",22, 0.5F);
        List<Item>lista1 =new ArrayList<>();
        lista1.add(item1);
        Exception exception1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(lista1, 100));
        assertEquals("Invalid character in item barcode!",exception1.getMessage());

        ////allitems={item,item2,item3},payment=550,item1={tina,1111,34,0.2},item2={mina,0211,301,0.1},item1={kika,22211,22,0}
        ///expected return true
        Item item=new Item("tina","1111",34, 0.2F);
        Item item2=new Item("mina","0211",301, 0.1F);
        Item item3=new Item("kika","22211",22, 0);
        List<Item>lista11 =new ArrayList<>();
        lista11.add(item);
        lista11.add(item2);
        lista11.add(item3);
        assertTrue(SILab2.checkCart(lista11,550));

//////allitems={item1,item2,item3},payment=0,item1={tina,1111,34,0.2},item2={mina,0211,301,0.1},item1={kika,22211,22,0}
///expected return false
       Item item111=new Item("tina","1111",34, 0.2F);
        Item item222=new Item("mina","0211",301, 0.1F);
        Item item333=new Item("kika","22211",22, 0);
        List<Item>lista22 =new ArrayList<>();
        lista22.add(item111);
        lista22.add(item222);
        lista22.add(item333);
        assertFalse(SILab2.checkCart(lista22,0));

    }
    @Test
    public void TestForMultipleCondition()
    { ///if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
        ///FXX
        Item m =new Item("kika","222",100,0);
        List<Item>list=new ArrayList<>();
        list.add(m);
        assertTrue(SILab2.checkCart(list,500));

        ///TTT
        Item s=new Item("kika1","022201",600, 0.1F);
        List<Item>lista=new ArrayList<>();
        lista.add(s);
        assertTrue(SILab2.checkCart(lista,500));
        //TFX
        Item ss=new Item("kika2","222201",800,0);
        List<Item>lista1=new ArrayList<>();
        lista1.add(ss);
        assertFalse(SILab2.checkCart(lista1,700));
        //TTF
        Item ss2=new Item("kika3","322201",500, 0.4F);
        List<Item>lista2=new ArrayList<>();
        lista2.add(ss2);
        assertFalse(SILab2.checkCart(lista2,30));
    }

}
