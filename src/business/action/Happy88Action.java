package business.action;

import static io.webfolder.cdp.type.constant.DownloadBehavior.Allow;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import frame.util.ExecUtil;
import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.command.Network;
import io.webfolder.cdp.command.Page;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;

public class Happy88Action {

	public void downLoadAppLimit() {
		for (int i = 0; i < 500; i++) {
			downLoadApp();
		}
	}

	public void downLoadApp() {
		ExecUtil.runExec("taskkill /f /t /im chrome.exe", "utf-8");
		ArrayList<String> command = new ArrayList<String>();
		// 不显示google 浏览器
		command.add("--incognito");// 进入隐身模式——保证浏览网页时，不留下任何痕迹。
		command.add("--start-maximized");// 浏览器启动后，窗口默认为最大化
		command.add("--disable-popup-blocking");// 关闭弹窗拦截
		Launcher launcher = new Launcher();
		SessionFactory sessionFactory = launcher.launch(command);
		sessionFactory.createBrowserContext();
		Session session = sessionFactory.create().installSizzle();
		session.setUserAgent(
				"MQQBrowser/26 Mozilla/5.0 (Linux; U; Android 2.3.7; zh-cn; MB200 Build/GRJ22; CyanogenMod-7) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
		Network network = session.getCommand().getNetwork();
		network.enable();
		session.wait(2000);
		network.clearBrowserCookies();
		Map<String, Object> headers = new HashMap<>();
		network.setExtraHTTPHeaders(headers);
		session.waitDocumentReady();
		session.navigate("http://liveh5.happy88.com/?channel=91017");
		session.wait(8000);
		session.evaluate(
				"document.getElementsByClassName('swiper-slide swiper-slide-duplicate swiper-slide-next')[0].click();");
		session.waitDocumentReady();
		session.wait(2000);
		session.evaluate("document.getElementById('btn-normal-download').click();");
		session.waitDocumentReady();
		session.wait(2000);
		session.getCommand().getNetwork().enable();
		Page page = session.getCommand().getPage();
		Path downloadPath = Paths.get("C:\\\\happay88").toAbsolutePath();
		page.setDownloadBehavior(Allow, downloadPath.toString());
		session.evaluate("document.getElementsByClassName('btn-ok w-btn btn-medium clickable is-gray')[0].click();");
		session.wait(30000);
		session.close();
		sessionFactory.close();
	}

	@Test
	public void UserDownload_logLimit() {
		for (int i = 0; i < 400; i++) {
			UserDownload_log(i);
		}
	}

	public void UserDownload_log(int i) {
		ExecUtil.runExec("taskkill /f /t /im chrome.exe", "utf-8");
		ArrayList<String> command = new ArrayList<String>();
		command.add("--incognito");// 进入隐身模式——保证浏览网页时，不留下任何痕迹。
//		command.add("--start-maximized");// 浏览器启动后，窗口默认为最大化
		command.add("--headless");// 不启动浏览器实体
		double random = Math.random();
		Launcher launcher = new Launcher();
		SessionFactory sessionFactory = launcher.launch(command);
		sessionFactory.createBrowserContext();
		Session session = sessionFactory.create().installSizzle();
		session.setUserAgent(
				"MQQBrowser/26 Mozilla/5.0 (Linux; U; Android 2.3.7; zh-cn; MB200 Build/GRJ22; CyanogenMod-7) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
		Network network = session.getCommand().getNetwork();
		network.enable();
		session.wait(2000);
		network.clearBrowserCookies();
		Map<String, Object> headers = new HashMap<>();
		network.setExtraHTTPHeaders(headers);
		session.waitDocumentReady();
		session.navigate("http://liveh5.happy88.com/?channel=91010");
		session.wait(3000);
		session.navigate("http://liveh5.happy88.com/ajax/room/room.ashx?action=ChannelClick&rd=" + random);
		session.wait(2000);
		System.out.println(i + 1 + ":" + random + ":" + (String) session.evaluate("window.document.body.textContent"));
		session.close();
		sessionFactory.close();
	}
}
