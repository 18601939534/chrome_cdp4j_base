package business.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import business.service.QingKaSignUpService;
import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.command.Network;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;

public class QingKaSignUpAction {
	QingKaSignUpService qingKaSignUpService = new QingKaSignUpService();

	public void signUpByAmount() {

		// for (int i = 0; i < 5000; i++) {

		ArrayList<String> command = new ArrayList<String>();
		// 不显示google 浏览器
		command.add("--incognito");
		command.add("--start-maximized");
		Launcher launcher = new Launcher();
		SessionFactory sessionFactory = launcher.launch(command);
		Session session = sessionFactory.create().installSizzle();

		session.setUserAgent(
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36");

		Network network = session.getCommand().getNetwork();
		network.enable();
		session.wait(1000);
		network.clearBrowserCookies();
		Map<String, Object> headers = new HashMap<>();
		network.setExtraHTTPHeaders(headers);
		session.wait(500);
		session.waitDocumentReady();

		session.navigate("http://cf.qingka.fm/qklive/live/html/livelist.html?src=yaowang25");
		session.wait(10000);
		session.waitDocumentReady();

		// QQ登陆
		session.evaluate("qqbologin();");
		session.wait(4000);
		session.waitDocumentReady();
		session.evaluate("document.getElementById(\"u\").value=\"8863171\";");
		session.wait(4000);
		session.evaluate("document.getElementById(\"p\").value=\"753159..\";");
		session.wait(4000);
		session.evaluate("document.getElementById(\"login_button\").click();");

		// 微博登陆
//		session.evaluate("weibologin();");
//		session.wait(4000);
//		session.waitDocumentReady();
//		session.evaluate("document.getElementById(\"userId\").value=\"18454357874\";");
//		session.wait(4000);
//		session.evaluate("document.getElementById(\"passwd\").value=\"q123123\";");
//		session.wait(4000);
//		session.evaluate("javascript:document.authZForm.onclick();");
//		session.click("WB_btn_login formbtn_01");

		// session.navigate("https://api.weibo.com/oauth2/authorize");
		// session.waitDocumentReady();
		// String content = (String) session.getContent();
		// System.out.println(content);
		// session.
		//
		//

		session.wait(4000);

		// 直接包装表单去提交吧

		// signUpWithWeibo("18454357874","q123123");

		// runEXEC("taskkill /f /t /im chrome.exe", "utf-8");

		// }
	}

	private void signUpWithWeibo(String username, String password) {

	}

	public String[] runEXEC(String cmdstr, String charset) {
		String[] res = { "0", "0" };
		try {
			System.out.println("-->" + cmdstr);

			Process process = Runtime.getRuntime().exec(cmdstr);
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), charset));
			String line1 = "";
			String line = "";

			while ((line1 = input.readLine()) != null) {
				line = line + "\r\n" + line1;
			}
			input.close();

			int hasError = process.waitFor();
			res[0] = String.valueOf(hasError);
			res[1] = line;
		} catch (Throwable t) {
		}

		return res;
	}

}
