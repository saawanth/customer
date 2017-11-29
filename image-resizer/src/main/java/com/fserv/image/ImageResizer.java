package com.fserv.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageResizer {

	protected void resize(String dirPath) {
		File fileDir = new File(dirPath);
		// write file.
		File outputDir = new File(dirPath, String.valueOf(System.currentTimeMillis()));
		if (!outputDir.exists()) {
			outputDir.mkdir();
		}

		File[] fitems = fileDir.listFiles();
		System.out.println(fitems.length);
		for (File fitem : fitems) {
			try {
				int size = 900;// size of the new image.
				// take the file as inputstream.
				InputStream imageStream = new FileInputStream(fitem);
				// read the image as a BufferedImage.
				BufferedImage image = javax.imageio.ImageIO.read(imageStream);
				// calender the sacleImage method.
				BufferedImage newImage = scaleImage(image, size);

				File file = new File(outputDir, fitem.getName());
				ImageIO.write(newImage, "JPG", file);
			} catch (Exception e) {
				System.out.println("Unable to save the image" + e.getMessage());
				// System.out.println(path);
			}
		}
	}

	private BufferedImage scaleImage(BufferedImage bufferedImage, int size) {
		double boundSize = size;
		int origWidth = bufferedImage.getWidth();
		int origHeight = bufferedImage.getHeight();
		double scale;

		if (origHeight > origWidth)
			scale = boundSize / origHeight;
		else
			scale = boundSize / origWidth;

		// * Don't scale up small images.
		if (scale > 1.0)
			return (bufferedImage);
		 int scaledWidth = (int) (scale * origWidth);
		 int scaledHeight = (int) (scale * origHeight);
//		int scaledWidth = 780;
//		int scaledHeight = 260;
		Image scaledImage = bufferedImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
		// new ImageIcon(image); // load image
		// scaledWidth = scaledImage.getWidth(null);
		// scaledHeight = scaledImage.getHeight(null);
		BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = scaledBI.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(scaledImage, 0, 0, null);
		g.dispose();
		return (scaledBI);
	}

	public static void main(String[] args) {
		ImageResizer imgResizer = new ImageResizer();
		// imgResizer.resize("C:\\Raja\\Akshaya\\OCI\\akshaya-passport");
		// imgResizer.resize("C:\\Raja\\Akshaya\\OCI\\sruthi-passport");
		// imgResizer.resize("C:\\Raja\\Akshaya\\OCI\\raja-passport\\passport-1");
		// imgResizer.resize("C:\\Raja\\Akshaya\\OCI\\raja-passport\\passport-2");
		 imgResizer.resize("C:\\Raja\\Akshaya\\images");
//		imgResizer.resize("C:\\Raja\\Akshaya\\images\\finger-prints");
	}
}
