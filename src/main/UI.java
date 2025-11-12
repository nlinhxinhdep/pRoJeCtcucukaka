package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Key;

public class UI {

    GamePanel gp;        // tham chiếu đến GamePanel để vẽ thông tin trò chơi
    Font arial_40;       // font chữ để hiển thị thông tin
    BufferedImage keyImage; // hình chiếc chìa khóa
    public boolean messageOn = false; // bật/tắt hiển thị thông báo tạm thời
    public String message = "";       // nội dung thông báo
    int messageCounter = 0;  // đếm thời gian hiển thị thông báo
    public boolean gameFinished = false;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40); // tạo font 40px

        // lấy hình chìa khóa từ class OBJ_Key
        OBJ_Key key = new OBJ_Key(gp);
        keyImage = key.image;
    }

    public void showMessage(String text) {
        message = text;      // đặt nội dung thông báo
        messageOn = true;    // bật hiển thị
    }

    public void draw(Graphics2D g2) {

        // 🏁 Nếu người chơi đã mở rương (gameFinished = true)
        if (gameFinished == true) {

            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the treasure!"; // nội dung hiển thị khi thắng
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            // canh giữa theo chiều ngang
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2; // giữa màn hình

            g2.drawString(text, x, y);

            // dừng game lại (giống RyiSnow)
            gp.gameThread = null;

        } else {

            // --- Hiển thị số lượng chìa khóa ---
            g2.setFont(arial_40);     // đặt font
            g2.setColor(Color.white); // đặt màu chữ trắng

            // Vẽ hình chiếc chìa khóa tại góc trái trên màn hình
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2,
                    gp.tileSize, gp.tileSize, null);

            // Hiển thị số lượng chìa khóa mà người chơi có
            g2.drawString("x " + gp.player.hasKey, 74, 65);

            // --- Hiển thị thông báo tạm thời ---
            if (messageOn == true) {
                g2.setFont(g2.getFont().deriveFont(30F)); // chỉnh cỡ chữ
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

                messageCounter++;

                // Sau 120 khung hình (2 giây) thì ẩn thông báo
                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }

}
