package test;

import org.junit.Test;

import frame.util.captcha.AliCaptchaUtil;

public class CaptchaTest {

	@Test
	public void gatCaptchaByBase64() {
		String captcha;
		String appcode = "18abdba3482f48eda0a3c51c4a9374d8";
		String v_pic = "iVBORw0KGgoAAAANSUhEUgAAAGQAAAAoCAMAAAA/pq9xAAAAM1BMVEX///9lZf6env54eP6Li/7Y2P6ysv7r6/7Fxf5zc/51df6trf6Bgf6QkP58fP5wcP7a2v6W28YTAAACvklEQVRIie1W7W7bMAw0SUlkuw3r+z/t+CXLstLGCVpgBcofbSBbOt7xRHrbfuIn/qdgBGpfDVIACUie3Y5U6v23ALetAdCFV29EgQJ0AaSwa+b/Hw5NscL9/FqUhAsAPg4DbWO4oLVkSaoSP6Nww4IfnXEVxEvi1RNwm3HtWCZioaOQ3MoBYYp7KExOglVhUa9pENbzIbDY3d67jKP18GQRfqmhhblKI7gZZ2UIXbJB6z0Mib2V4Dek6XMHK74dY1n0tdlKRZ/u5N6HGTToj4FprTNpeNFDCF1J9aBqVZdDSgk2BwVvwAwaWI13y4SRq4EgcbyhkO4kmA1oIAWPKytMp9HsxhMNxroAf/XAqg/UFs1QXu2Cn0yOBxDmSbUqoaz4doPSeyiuhmQWb62x6aAUm6VSrSx1KTxSsHGHwk5p2MQMWYOGxIOtE7X7L/qgJNnmrt5kkbtRsNFkSHDkwN0mOw1VLJe6GgWasvNyWxK4sXCxNrWAQLARlx26zxRyvWdR65GpCWW2iqI3x9a7znCePAmCoVQ3c0Cqc5brXJrWKPcWS8QQVGnJzUZTSc33RNwkJcHTzM0hdfnVhQQYrQhVlC5XGIq96Lt/7Jd2ghOIIdsNZcz3OCCNHHmz6q3R36eDqOlt/Us7SF3EShA7qlL6LLjrfr9cUXbcx4gNnzbuQRa9HAqKsIxa09Cath4XINUdG4Wfxkg6z1vEGMOyt0PsDUsATsM2x6Jqg27m5gLImEz7GEmd7apZe+kHcPxmHEsm8AriVXCfQZb80Gj6ZJfMFONWDEl8aAFMvWlmYmMxqhAgxr2caueTvfaOxCbQNE1rwyZzuzo1L/9csTU3c+2Fn6PadDp6aumBHwcjhXEk9lW6+XElcliVcuVb7VYEiDz3ZXU13AI41+/Tg6HIueSfH89/6z4S/PUQ3zD+ATWMDktijXgyAAAAAElFTkSuQmCC";
		String v_type = "cn";
		captcha = AliCaptchaUtil.gatCaptchaByBase64(appcode, v_pic, v_type);
		System.out.println(captcha);
	}

}
