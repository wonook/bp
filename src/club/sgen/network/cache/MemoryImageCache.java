package club.sgen.network.cache;

import java.io.File;

import club.sgen.network.BitmapHandler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;

public class MemoryImageCache implements ImageCache {

	private LruCache<String, Bitmap> lruCache;

	public MemoryImageCache(int maxCount) {
		lruCache = new LruCache<String, Bitmap>(maxCount);
	}

	@Override
	public void addBitmap(String key, Bitmap bitmap) {
		if (bitmap == null)
			return;
		lruCache.put(key, bitmap);
	}

	@Override
	public void addBitmap(String key, File bitmapFile) {
		if (bitmapFile == null)
			return;
		if (!bitmapFile.exists())
			return;

		Bitmap bitmap = BitmapFactory.decodeFile(bitmapFile.getAbsolutePath());

		lruCache.put(key, bitmap);
	}

	@Override
	public void addBitmap(String key, File bitmapFile, BitmapHandler handler) {
		if (bitmapFile == null)
			return;
		if (!bitmapFile.exists())
			return;

		Bitmap bitmap = BitmapFactory.decodeFile(bitmapFile.getAbsolutePath());
		Bitmap ret = handler.handleBitmap(bitmap);
		bitmap.recycle();
		lruCache.put(key, ret);
	}

	@Override
	public Bitmap getBitmap(String key, BitmapHandler handler) {
		return getBitmap(key);
	}

	@Override
	public Bitmap getBitmap(String key) {
		return lruCache.get(key);
	}

	@Override
	public void clear() {
		lruCache.evictAll();
	}

}