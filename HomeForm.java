import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Integer.*;

public class HomeForm extends JFrame implements ActionListener {
    private JPanel MainPanel;
    private JPanel headerPanel;
    private JPanel infoPanel;
    private JPanel contentPanel;
    private JButton checkPersceptionButton;
    private JComboBox gateTypeCB;
    private JSpinner maxErrorSpinner;
    double[] x0= new double[4];
    double[] x1= new double[4];
    double[] x2= new double[4];
    double[] x3= new double[4];
    double[] d= new double[4];
    double[] y= new double[4];
    double[] f= new double[4];
    double W0,W1,W2,W3;
    double µ=0;
    double error=0;



    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==checkPersceptionButton){
  if(isValidated()){


        µ=getRandomDoubleBetweenRange(0.01,0.50);
        W0=getRandomDoubleBetweenRange(1, 5);
        W1=getRandomDoubleBetweenRange(1, 5);
        W2=getRandomDoubleBetweenRange(1, 5);
        W3=getRandomDoubleBetweenRange(1, 5);

        if(gateTypeCB.getSelectedItem()=="OR"){
            d[0]=1;
            d[1]=1;
            d[2]=1;
            d[3]=-1;

            for(int i=0;i<=3;i++){
                y[i]=f(W0*x0[i]+W1*x1[i]+W2*x2[i]+W3*x3[i]);
                if(y[i]!=d[i]){
                    JOptionPane.showMessageDialog(null,
                            "Error Width : W"+i+
                                    "\nµ : "+µ+
                                    "\nCurrent Weight : "+
                                    "\nW0 : "+W0+
                                    "\nW1 : "+W1+
                                    "\nW2 : "+W2+
                                    "\nW3 : "+W3+
                                    "\nError = d(t)-y(t) = "+ d[i] +"-("+y[i]+") = "+(d[i]-y[i])+
                                    "\nNew Weight : "+
                                    "\nW0 : "+(W0+µ*(d[0]-f(W0*x0[0]+W1*x1[0]+W2*x2[0]+W3*x3[0]))*x0[i])+
                                    "\nW1 : "+(W1+µ*(d[1]-f(W0*x0[1]+W1*x1[1]+W2*x2[1]+W3*x3[1]))*x1[i])+
                                    "\nW2 : "+(W2+µ*(d[2]-f(W0*x0[2]+W1*x1[2]+W2*x2[2]+W3*x3[2]))*x2[i])+
                                    "\nW3 : "+(W3+µ*(d[3]-f(W0*x0[3]+W1*x1[3]+W2*x2[3]+W3*x3[3]))*x3[i]));
                    error++;
                    if(error==parseInt(maxErrorSpinner.getValue().toString())){
                     i=4;
                     error=0;
                    }

                }
                if(i==3 && error==0){
                    JOptionPane.showMessageDialog(null,"No Error");
                }
            }

        }
        if(gateTypeCB.getSelectedItem()=="AND"){
            d[0]=1;
            d[1]=-1;
            d[2]=-1;
            d[3]=-1;

            for(int i=0;i<=3;i++){
                y[i]=f(W0*x0[i]+W1*x1[i]+W2*x2[i]+W3*x3[i]);
                if(y[i]!=d[i]){
                    JOptionPane.showMessageDialog(null,
                            "Error Width : W"+i+
                                    "\nµ : "+µ+
                                    "\nCurrent Weight : "+
                                    "\nW0 : "+W0+
                                    "\nW1 : "+W1+
                                    "\nW2 : "+W2+
                                    "\nW3 : "+W3+
                                    "\nError = d(t)-y(t) = "+ d[i] +"-("+y[i]+") = "+(d[i]-y[i])+
                                    "\nNew Weight : "+
                                    
                                    "\nW0 : "+(W0+µ*(d[0]-f(W0*x0[0]+W1*x1[0]+W2*x2[0]+W3*x3[0]))*x0[i])+
                                    "\nW1 : "+(W1+µ*(d[1]-f(W0*x0[1]+W1*x1[1]+W2*x2[1]+W3*x3[1]))*x1[i])+
                                    "\nW2 : "+(W2+µ*(d[2]-f(W0*x0[2]+W1*x1[2]+W2*x2[2]+W3*x3[2]))*x2[i])+
                                    "\nW3 : "+(W3+µ*(d[3]-f(W0*x0[3]+W1*x1[3]+W2*x2[3]+W3*x3[3]))*x3[i]));
                    error++;
                    if(error==parseInt(maxErrorSpinner.getValue().toString())){
                        i=4;
                        error=0;
                    }

                }
                if(i==3 && error==0){
                    JOptionPane.showMessageDialog(null,"No Error");
                }
            }

        }
        if(gateTypeCB.getSelectedItem()=="XOR"){
            d[0]=1;
            d[1]=-1;
            d[2]=1;
            d[3]=-1;


            for(int i=0;i<=3;i++){
                y[i]=f(W0*x0[i]+W1*x1[i]+W2*x2[i]+W3*x3[i]);
                if(y[i]!=d[i]){
                    JOptionPane.showMessageDialog(null,
                            "Error Width : W"+i+
                                    "\nµ : "+µ+
                                    "\nCurrent Weight : "+
                                    "\nW0 : "+W0+
                                    "\nW1 : "+W1+
                                    "\nW2 : "+W2+
                                    "\nW3 : "+W3+
                                    "\nError = d(t)-y(t) = "+ d[i] +"-("+y[i]+") = "+(d[i]-y[i])+
                                    "\nNew Weight : "+
                                    "\nW0 : "+(W0+µ*(d[0]-f(W0*x0[0]+W1*x1[0]+W2*x2[0]+W3*x3[0]))*x0[i])+
                                    "\nW1 : "+(W1+µ*(d[1]-f(W0*x0[1]+W1*x1[1]+W2*x2[1]+W3*x3[1]))*x1[i])+
                                    "\nW2 : "+(W2+µ*(d[2]-f(W0*x0[2]+W1*x1[2]+W2*x2[2]+W3*x3[2]))*x2[i])+
                                    "\nW3 : "+(W3+µ*(d[3]-f(W0*x0[3]+W1*x1[3]+W2*x2[3]+W3*x3[3]))*x3[i]));
                    error++;
                    if(error==parseInt(maxErrorSpinner.getValue().toString())){
                        i=4;
                        error=0;
                    }

                }
                if(i==3 && error==0){
                    JOptionPane.showMessageDialog(null,"No Error");
                }
            }
        }
        if(gateTypeCB.getSelectedItem()=="XNOR"){
            d[0]=-1;
            d[1]=1;
            d[2]=-1;
            d[3]=1;
            error=0;
            for(int i=0;i<=3;i++){
                y[i]=f(W0*x0[i]+W1*x1[i]+W2*x2[i]+W3*x3[i]);
                if(y[i]!=d[i]){
                        JOptionPane.showMessageDialog(null,
                                "Error Width : W"+i+
                                        "\nµ : "+µ+
                                        "\nCurrent Weight : "+
                                        "\nW0 : "+W0+
                                        "\nW1 : "+W1+
                                        "\nW2 : "+W2+
                                        "\nW3 : "+W3+
                                        "\nError = d(t)-y(t) = "+ d[i] +"-("+y[i]+") = "+(d[i]-y[i])+
                                        "\nNew Weight : "+
                                        "\nW0 : "+(W0+µ*(d[0]-f(W0*x0[0]+W1*x1[0]+W2*x2[0]+W3*x3[0]))*x0[i])+
                                        "\nW1 : "+(W1+µ*(d[1]-f(W0*x0[1]+W1*x1[1]+W2*x2[1]+W3*x3[1]))*x1[i])+
                                        "\nW2 : "+(W2+µ*(d[2]-f(W0*x0[2]+W1*x1[2]+W2*x2[2]+W3*x3[2]))*x2[i])+
                                        "\nW3 : "+(W3+µ*(d[3]-f(W0*x0[3]+W1*x1[3]+W2*x2[3]+W3*x3[3]))*x3[i]));
                        error++;
                    if(error==parseInt(maxErrorSpinner.getValue().toString())){
                            i=4;
                            error=0;
                        }
                }
                if(i==3 && error==0){
                    JOptionPane.showMessageDialog(null,"No Error");
                }
            }

        }
    }
    }
    }


    public HomeForm() {
        //Define X0
        x0[0]=1;
        x0[1]=1;
        x0[2]=1;
        x0[3]=1;
        //Define X1
        x1[0]=1;
        x1[1]=1;
        x1[2]=-1;
        x1[3]=-1;
        //Define X2
        x2[0]=1;
        x2[1]=-1;
        x2[2]=1;
        x2[3]=-1;
        //Define X3
        x3[0]=-1;
        x3[1]=-1;
        x3[2]=-1;
        x3[3]=-1;

        setTitle("Learning Algorithm - 21810285 - Yavuz GUNAY");
        setSize(600, 475);
        headerPanel.setSize(600,50);
        MainPanel.setSize(600,450);
        infoPanel.setSize(300,400);
        contentPanel.setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        setUndecorated(true);
        add(MainPanel);
        maxErrorSpinner.setValue(1);
        gateTypeCB.addItem(new AnyObject("Select Gate Type", "0").value);
        gateTypeCB.addItem(new AnyObject("OR", "1").value);
        gateTypeCB.addItem(new AnyObject("AND", "2").value);
        gateTypeCB.addItem(new AnyObject("XOR", "3").value);
        gateTypeCB.addItem(new AnyObject("XNOR", "4").value);
        checkPersceptionButton.addActionListener(this);
        }

        public static void main(String[] args) {
            HomeForm homeForm = new HomeForm();
            homeForm.setVisible(true);

        }


    public static double getRandomDoubleBetweenRange(double min, double max){
        Random random = new Random();
        return random.doubles(min, max)
                .findFirst()
                .getAsDouble();
    }
    public static double f(double value){
        if(value<=0.0){
            value=-1;
        }
        if (value>=0.0){
            value=1;
        }
        return value;
    }

    private class AnyObject {
        private String value;
        private String text;
        public  AnyObject(String value, String text) {
            this.value = value;
            this.text = text;
        }
    }

    public boolean isValidated() {
        boolean validated = true;
        if(gateTypeCB.getSelectedIndex()==0){
            validated=false;
            JOptionPane.showMessageDialog(null,"Please Select Gate Type","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if(Integer.parseInt(maxErrorSpinner.getValue().toString())<=0){
            validated=false;
            JOptionPane.showMessageDialog(null,"Please select a max error rate between 1 and 4.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if(Integer.parseInt(maxErrorSpinner.getValue().toString())>4){
            validated=false;
            JOptionPane.showMessageDialog(null,"Please select a max error rate between 1 and 4.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return validated;
    }
    }

