package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Chest extends SuperObject {
	
    // Thêm biến GamePanel để truy cập gp.tileSize
	GamePanel gp; 
    
    // Sửa constructor để nhận GamePanel gp
    public OBJ_Chest(GamePanel gp) {
        this.gp = gp;
        name = "Chest";
        collision = true; // Rương thường có va chạm để chặn người chơi đi xuyên qua
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/object/chest.png"));
            
            // THÊM: Sử dụng uTool.scaleImage để thay đổi kích thước ảnh
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize); 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}