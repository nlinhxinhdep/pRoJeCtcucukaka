package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Boots extends SuperObject {
	
    // Thêm biến GamePanel để truy cập gp.tileSize
	GamePanel gp; 
    
    // Sửa constructor để nhận GamePanel gp
	public OBJ_Boots(GamePanel gp) { 
        // Gán gp (nếu cần thiết để sử dụng ở nơi khác), nhưng ở đây chỉ dùng để scale
        this.gp = gp; 
        
        name = "Boots";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/object/boots.png"));
            
            // THÊM: Sử dụng uTool.scaleImage để thay đổi kích thước ảnh
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize); 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Bạn đã đặt collision = true trong code gốc, nhưng Boots thường không có va chạm
        // để người chơi có thể nhặt được. Tôi sẽ để lại tùy thuộc vào thiết kế game của bạn.
        collision = true; 
    }
}