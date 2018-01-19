package obrazovka;

import org.ini4j.Ini;

public class Obsah_YouTubeVideo extends Obsah {
	
	public static final String INI_KATEGORIA_OBSAH_YOUTUBE_VIDEO = INI_KATEGORIA_OBSAH + ".YouTubeVideo";	
	public static final String INI_HODNOTA_TYP_YOUTUBE_VIDEO = "YouTubeVideo";		
	public static final String INI_KLUC_VIDEO_ID = "VideoId";
	
	public Obsah_YouTubeVideo(int mojeId, Ini mojKonfiguracnySubor)
	{
		super(mojeId, mojKonfiguracnySubor);		

	}
	
	protected void zobrazeny()
	{
	}
	
	protected void skryty()
	{
	}
}
