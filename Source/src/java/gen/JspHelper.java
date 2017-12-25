/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package gen;

import java.util.List;

/**
 *
 * @author VATSAL
 * 
 * This class is used by jstl user defined function (definition in portalTLD.tld)
 */
public class JspHelper {
    public static boolean contains(List list, Object o) {
      return list.contains(o);
   }
    public static boolean equalsIgnoreCase(String a, String b) {
        return a.equalsIgnoreCase(b);
   }
}
