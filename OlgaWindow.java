package iristk.app.olgaVA;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class OlgaWindow extends JPanel implements ActionListener, ItemListener {

	public int select; 
	public void init() {
		// TODO Auto-generated method stub
		BufferedImage myPicture1 = null, myPicture2 = null, myPicture3 = null, myPicture4 = null;
		try {
			myPicture1 = ImageIO.read(new File("C:/Users/DJ/IrisTK/app/OlgaVA/src/iristk/app/olgaVA/audi.jpg"));
			myPicture2 = ImageIO.read(new File("C:/Users/DJ/IrisTK/app/OlgaVA/src/iristk/app/olgaVA/bmw.jpg"));
			myPicture3 = ImageIO.read(new File("C:/Users/DJ/IrisTK/app/OlgaVA/src/iristk/app/olgaVA/airon.jpg"));
			myPicture4 = ImageIO.read(new File("C:/Users/DJ/IrisTK/app/OlgaVA/src/iristk/app/olgaVA/VW.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//JFrame frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
		//JLabel picLabel2= new JLabel(new ImageIcon(myPicture2));
		//JLabel picLabel3 = new JLabel(new ImageIcon(myPicture3));
		//JLabel picLabel4 = new JLabel(new ImageIcon(myPicture4));
        ImageIcon originalImage1 = new ImageIcon(myPicture1);
        System.out.println("OlgaWindow.init()"+originalImage1.getIconWidth() / 4);
        System.out.println("OlgaWindow.init()"+originalImage1.getIconHeight() / 4);
        ImageIcon scaledImage1 = new ImageIcon(originalImage1.getImage()
                .getScaledInstance(200,
                        100, Image.SCALE_SMOOTH));
        JLabel picLabel1 = new JLabel(scaledImage1);
        ImageIcon originalImage2 = new ImageIcon(myPicture2);
        ImageIcon scaledImage2 = new ImageIcon(originalImage2.getImage()
                .getScaledInstance(200,
                        100, Image.SCALE_SMOOTH));
        JLabel picLabel2 = new JLabel(scaledImage2);
        ImageIcon originalImage3 = new ImageIcon(myPicture3);
        ImageIcon scaledImage3 = new ImageIcon(originalImage3.getImage()
                .getScaledInstance(200,
                        100 , Image.SCALE_SMOOTH));
        JLabel picLabel3 = new JLabel(scaledImage3);
        ImageIcon originalImage4 = new ImageIcon(myPicture4);
        ImageIcon scaledImage4 = new ImageIcon(originalImage4.getImage()
                .getScaledInstance(200,
                        100, Image.SCALE_SMOOTH));
        JLabel picLabel4 = new JLabel(scaledImage4);
        
        picLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.err.println("in");
                System.out
						.println("OlgaWindow.init().new MouseAdapter() {...}.mouseEntered()"+picLabel1.getLocation());
                JLabel picLabel = new JLabel(scaledImage1);
                add(picLabel);
                picLabel1.setLocation(350, 150);
                picLabel1.setIcon(scaledImage1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	picLabel1.setLocation(76, 5);
            	picLabel1.setIcon(scaledImage1);
            }
        });
        picLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.err.println("in");
                System.out
						.println("OlgaWindow.init().new MouseAdapter() {...}.mouseEntered()"+picLabel4.getLocation());
                picLabel4.setLocation(350, 150);
                picLabel4.setIcon(scaledImage4);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	picLabel4.setLocation(691, 5);
            	picLabel4.setIcon(scaledImage4);
            }
        });
        
        picLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.err.println("in");
                System.out
						.println("OlgaWindow.init().new MouseAdapter() {...}.mouseEntered()"+picLabel2.getLocation());
                picLabel2.setLocation(350, 150);
                picLabel2.setIcon(scaledImage2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	picLabel2.setLocation(281, 5);
            	picLabel2.setIcon(scaledImage2);
            }
        });
        
        picLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.err.println("in");
                System.out
						.println("OlgaWindow.init().new MouseAdapter() {...}.mouseEntered()"+picLabel3.getLocation());
                picLabel3.setLocation(350, 150);
                picLabel3.setIcon(scaledImage3);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	picLabel3.setLocation(486, 5);
            	picLabel3.setIcon(scaledImage3);
            }
        });

        
		add(picLabel1);
		add(picLabel2);
		add(picLabel3);
		add(picLabel4);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
