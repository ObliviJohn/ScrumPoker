package View;

import javax.swing.*;

import Model.Card;
import Model.Hand;

import java.util.List;

public class ImageHandler {
    private ImageIcon[][] imageArray = new ImageIcon[4][13];
    private ImageIcon backside;

    public ImageHandler() {
        //Image order Clubs,Diamonds,Spades,Hearts
        int e = 1;
        //Backside/hidden card
        this.backside = new ImageIcon("src/Resources/Cards/Backside.png");
        for(int i = 0;i<imageArray.length;i++){
            for (int j = 0; j<13;j++){
                this.imageArray[i][j]= new ImageIcon("src/Resources/Cards/Card_"+(e)+".png");
                e++;
            }
        }
    }

    public ImageIcon getBackside() {
        return backside;
    }

    public ImageIcon[] handImages(List<Card> hand){
        ImageIcon[] images = new ImageIcon[5];
        int i = 0;
        for(Card c:hand){
            images[i]=cardMatcher(c);
            i++;
        }
        return images;
    }
    private ImageIcon cardMatcher(Card card){
        ImageIcon image;
        int i = card.getValue()-1;
        switch (card.getSuit()){
            case CLUBS: image = imageArray[0][i]; break;
            case DIAMONDS: image = imageArray[1][i]; break;
            case HEARTS: image = imageArray[2][i]; break;
            case SPADES: image = imageArray[3][i]; break;
            default: image = backside; break;
        }
        return image;
    }
}
