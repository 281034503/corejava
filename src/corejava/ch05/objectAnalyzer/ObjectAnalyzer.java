package corejava.ch05.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {

	private ArrayList<Object> visited = new ArrayList<>();

	// 将对象转换为列出所有字段的字符串表示
	public String toString(Object obj) {
		if (obj == null)
			return "null";
		if (visited.contains(obj))
			return "...";
		visited.add(obj);
		Class cl = obj.getClass();
		if (cl == String.class)
			return (String) obj;
		if (cl.isArray()) {
			String r = cl.getCanonicalName() + "[]{";
			for (int i = 0; i < Array.getLength(obj); i++) {
				if (i > 0)
					r += ",";
				Object val = Array.get(obj, i);
				if (cl.getComponentType().isPrimitive())
					r += val;
				else
					r += toString(val);
			}
			return r + "}";
		}

		String r = cl.getName();
		// 检查这个类和所有超类的字段
		do {
			r += "[";
			Field[] fields = cl.getDeclaredFields();
			AccessibleObject.setAccessible(fields, true);
			// 获取所有字段的名称和值
			for (Field f : fields) {
				if (!Modifier.isStatic(f.getModifiers())) {
					if (!r.endsWith("["))
						r += ",";
					r += f.getName() + "=";
					try {
						Class t = f.getType();
						Object val = f.get(obj);
						if (t.isPrimitive())
							r += val;
						else
							r += toString(val);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
			r += "]";
			cl = cl.getSuperclass();
		} while (cl != null);
		return r;
	}

}
