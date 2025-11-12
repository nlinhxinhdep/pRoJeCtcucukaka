package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Door extends SuperObject {
	
    // Khai báo GamePanel để truy cập các biến game như tileSize
	GamePanel gp; 
    
    // Sửa constructor để nhận GamePanel gp
    public OBJ_Door(GamePanel gp) {
        this.gp = gp;
        name = "Door";
        
        // Cửa cần va chạm để chặn người chơi đi qua, trừ khi được mở
        collision = true; 
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/object/door.png"));
            
            // THÊM: Sử dụng uTool.scaleImage để thay đổi kích thước ảnh theo kích thước ô gạch chuẩn
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize); 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}