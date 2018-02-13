package obrazovka;

import org.ini4j.Ini;

import javafx.scene.web.WebView;

public class Obsah_YouTubeVideo extends Obsah {

	public static final String INI_KATEGORIA_OBSAH_YOUTUBE_VIDEO = INI_KATEGORIA_OBSAH + ".YouTubeVideo";
	public static final String INI_HODNOTA_TYP_YOUTUBE_VIDEO = "YouTubeVideo";
	public static final String INI_KLUC_VIDEO_ID = "VideoId";

	public static final String YOUTUBE_URL = "https://www.youtube.com/embed/";
	public static final String URL_PARAMS = "?autoplay=1&cc_load_policy=0&controls=0&disablekb=1&fs=0&modestbranding=1&rel=0&loop=1&playlist=";

	private String videoId;
	WebView webView;

	public Obsah_YouTubeVideo(int mojeId, Ini mojKonfiguracnySubor) {
		super(mojeId, mojKonfiguracnySubor);
		videoId = mojKonfiguracnySubor.get(INI_KATEGORIA_OBSAH_YOUTUBE_VIDEO, INI_KLUC_VIDEO_ID);
		webView = new WebView();
	}

	public String odkazNaVideo() {
		return YOUTUBE_URL + videoId + URL_PARAMS + videoId;
	}

	@Override
	protected void zobrazeny() {
		webView.getEngine().load(odkazNaVideo());
		Main.root.setCenter(webView);
	}

	@Override
	protected void skryty() {
		webView.getEngine().load(null);
		Main.root.setCenter(null);
	}
}
