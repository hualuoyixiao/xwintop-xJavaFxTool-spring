package com.xwintop.xJavaFxTool;

import com.xwintop.xJavaFxTool.fxmlView.IndexView;
import com.xwintop.xJavaFxTool.utils.JavaFxViewUtil;
import com.xwintop.xJavaFxTool.utils.XJavaFxSystemUtil;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import de.felixroske.jfxsupport.GUIState;
import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/** 
 * @ClassName: Main 
 * @Description: 启动类
 * @author: xufeng
 * @date: 2017年11月10日 下午4:34:11  
 */
@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure(Main.class.getResource("/config/log4j.properties"));//加载日志配置
		XJavaFxSystemUtil.initSystemLocal();//初始化本地语言
		XJavaFxSystemUtil.addJarByLibs();//添加外部jar包

		SplashScreen splashScreen = new SplashScreen(){
			@Override
			public String getImagePath() {
				return "/images/javafx.png";
			}
		};
		launch(Main.class,IndexView.class,splashScreen,args);
//		launchApp(Main.class, IndexView.class, args);
	}

	@Override
	public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
		super.beforeInitialView(stage, ctx);
		Scene scene = JavaFxViewUtil.getJFXDecoratorScene(stage,"",null,new AnchorPane());
		stage.setScene(scene);
		GUIState.setScene(scene);
	}
}