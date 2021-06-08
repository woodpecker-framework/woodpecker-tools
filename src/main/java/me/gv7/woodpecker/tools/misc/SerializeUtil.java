package me.gv7.woodpecker.tools.misc;

import java.io.*;

public class SerializeUtil {
	/**
	 * 将对象序列化
	 *
	 * @param obj 要序列化的对象
	 * @return 序列化数据
	 * @throws IOException
	 */
	public static byte[] serialize(final Object obj) throws IOException {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		serialize(obj, out);
		return out.toByteArray();
	}

	/**
	 * 将对象序列化
	 *
	 * @param obj 要序列化的对象
	 * @param out 将序列化数据导入的流
	 * @throws IOException
	 */
	public static void serialize(final Object obj, final OutputStream out) throws IOException {
		final ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(obj);
	}

	/**
	 * 将对象反序列化
	 *
	 * @param serialized 要反序列化的数据
	 * @return 反序列化后的对象
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deserialize(final byte[] serialized) throws IOException, ClassNotFoundException {
		final ByteArrayInputStream in = new ByteArrayInputStream(serialized);
		return deserialize(in);
	}

	/**
	 * 将对象反序列化
	 *
	 * @param in 包含序列化数据的流
	 * @return 反序列化后的对象
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Object deserialize(final InputStream in) throws ClassNotFoundException, IOException {
		final ObjectInputStream objIn = new ObjectInputStream(in);
		return objIn.readObject();
	}
}