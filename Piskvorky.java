import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Piskvorky implements ActionListener 
{
    
    private final JFrame frame = new JFrame("Piskvorky 3X3");
    
    
    String uvodnyLabelTlacidla = "";
    
    
    JButton[] pole = new JButton[9];
    
    
    private String pismeno = "";
    
    
    private int pocetStlacenych = 0;
    
    
    private boolean vitazstvo = false;
    
    
   
    public Piskvorky()
    {
        
        for (int i = 0; i < 9; i++)
        {
            pole[i] = new JButton(uvodnyLabelTlacidla);
        }
        
        
        
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3));
    
    
        
        for (int i = 0; i < 9; i++)
        {
            frame.add(pole[i]);
        }


       
        for (int i = 0; i < 9; i++)
        {
            pole[i].addActionListener(this);
        }  

    
        
        frame.setVisible(true);
    }
    
    
    

    
    @Override
    public void actionPerformed(ActionEvent a) 
    {
        
        pocetStlacenych++;
        
        
        if (pocetStlacenych % 2 == 1)
        {
            pismeno = "X";
        }
        
        if (pocetStlacenych % 2 == 0)
        {
            pismeno = "O";
        }
        
        
        
        for (int j = 0; j < 9; j++)
        {
            if (a.getSource() == pole[j])
            {
                pole[j].setText(pismeno);
                pole[j].setEnabled(false);
            }
        }

        
        
        if ( (pole[0].getText() == null ? pole[1].getText() == null : pole[0].getText().equals(pole[1].getText())) && (pole[1].getText() == null ? pole[2].getText() == null : pole[1].getText().equals(pole[2].getText())) && !"".equals(pole[2].getText()))
        {
            vitazstvo = true;
        }
        else if ((pole[3].getText() == null ? pole[4].getText() == null : pole[3].getText().equals(pole[4].getText())) && (pole[4].getText() == null ? pole[5].getText() == null : pole[4].getText().equals(pole[5].getText())) && !"".equals(pole[3].getText()))
        {
            vitazstvo = true;
        }
        else if ((pole[6].getText() == null ? pole[7].getText() == null : pole[6].getText().equals(pole[7].getText())) && (pole[7].getText() == null ? pole[8].getText() == null : pole[7].getText().equals(pole[8].getText())) && !"".equals(pole[6].getText()))
        {
            vitazstvo = true;
        }
        
        
        
        else if ((pole[0].getText() == null ? pole[3].getText() == null : pole[0].getText().equals(pole[3].getText())) && (pole[3].getText() == null ? pole[6].getText() == null : pole[3].getText().equals(pole[6].getText())) && !"".equals(pole[0].getText()))
        {
            vitazstvo = true;
        }
        else if ((pole[1].getText() == null ? pole[4].getText() == null : pole[1].getText().equals(pole[4].getText())) && (pole[4].getText() == null ? pole[7].getText() == null : pole[4].getText().equals(pole[7].getText())) && !"".equals(pole[1].getText()))
        {
            vitazstvo = true;
        }
        else if ((pole[2].getText() == null ? pole[5].getText() == null : pole[2].getText().equals(pole[5].getText())) && (pole[5].getText() == null ? pole[8].getText() == null : pole[5].getText().equals(pole[8].getText())) && !"".equals(pole[2].getText()))
        {
            vitazstvo = true;
        }
        
        
        
        else if ((pole[0].getText() == null ? pole[4].getText() == null : pole[0].getText().equals(pole[4].getText())) && (pole[4].getText() == null ? pole[8].getText() == null : pole[4].getText().equals(pole[8].getText())) && !"".equals(pole[0].getText()))
        {
            vitazstvo = true;
        }
        else vitazstvo = (pole[2].getText() == null ? pole[4].getText() == null : pole[2].getText().equals(pole[4].getText())) && (pole[4].getText() == null ? pole[6].getText() == null : pole[4].getText().equals(pole[6].getText())) && !"".equals(pole[2].getText()); // Ak nikto nevyhral, nastavíme premennú vitazstvo na false.
        
        
        
        
        if (vitazstvo == true)
        {
            JOptionPane.showMessageDialog(null, "Hráč "+ pismeno + " Vyhráva");
            pocetStlacenych = 0;
            for (int j = 0; j < 9; j++)
            {
                pole[j].setText("");
                pole[j].setEnabled(true);
            }
        }
        else if (pocetStlacenych == 9 && vitazstvo == false)
        {
            JOptionPane.showMessageDialog(null, "Remíza");
            pocetStlacenych = 0;
            for (int j = 0; j < 9; j++)
            {
                pole[j].setText("");
                pole[j].setEnabled(true);
            }
        }
    }
    
    public static void main(String[] args)
    {
        
        Piskvorky piskvorky = new Piskvorky();
    }
}