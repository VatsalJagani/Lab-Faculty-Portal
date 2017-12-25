package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/tags/Header.tag");
    _jspx_dependants.add("/WEB-INF/tags/Footer.tag");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_h_Header_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<style>\n");
      out.write("    @media (min-width: 768px) {\n");
      out.write("        .sidebar {\n");
      out.write("            width: 260px;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    .navbar-header {\n");
      out.write("        float: left;\n");
      out.write("        padding: 15px;\n");
      out.write("        text-align: center;\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("    .navbar-brand {float:none;}\n");
      out.write("</style>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/js/coin-slider.min.js\"></script>\n");
      out.write("\n");
      out.write("    <nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("        <div class=\"navbar-header text-center\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\"><span style=\"color:white\">Faculty</span> Portal</a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("            <div class=\"sidebar-nav navbar-collapse\">\n");
      out.write("                <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("                    <li class=\"sidebar-search\">\n");
      out.write("                        <div class=\"hidden-xs text-center\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/ddu_logo.jpg\" class=\"img\" height=\"85\" width=\"85\" alt=\"DDU logo\" />\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div class=\"login-panel panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <h3 class=\"panel-title\">Sign-In to Faculty Portal</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <form role=\"form\" action=\"doLogin\" method=\"post\">\n");
      out.write("                                    <fieldset>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input class=\"form-control\" placeholder=\"User-Name\" name=\"username\" type=\"text\"  required autofocus/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <input class=\"form-control\" placeholder=\"Password\" name=\"password\" type=\"password\"  required/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <input type=\"submit\" class=\"btn btn-lg btn-success btn-block\" value=\"Login\" />\n");
      out.write("                                    </fieldset>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <div>\n");
      out.write("        <div>\n");
      out.write("            <div style=\"margin-left:300px;margin-top:120px;margin-right:0px;padding-right:0px;\">\n");
      out.write("                <div id=\"main_carousel\" class=\"carousel slide row\" data-ride=\"carousel\">\n");
      out.write("                    <!-- Indicators -->\n");
      out.write("                    <ol class=\"carousel-indicators\">\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"1\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"2\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"3\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"4\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"5\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"6\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"7\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"8\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"9\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"10\"></li>\n");
      out.write("                        <li data-target=\"#main_carousel\" data-slide-to=\"11\"></li>\n");
      out.write("                    </ol>\n");
      out.write("                    <!-- Wrapper for slides -->\n");
      out.write("                    <div class=\"carousel-inner\" role=\"listbox\"> \n");
      out.write("                        <div class=\"item active\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide1.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide2.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide3.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide4.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide5.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide6.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide7.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide8.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide9.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide10.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide11.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.Root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("styles/img/slide12.jpg\" width=\"920\" height=\"360\" alt=\"\" />\n");
      out.write("                            <div class=\"carousel-caption\"></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
      if (_jspx_meth_h_Footer_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    $('.carousel').carousel({\n");
      out.write("                        interval: 2000\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    $('.carousel').carousel('cycle');\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            </body>\n");
      out.write("            </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_h_Header_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:Header
    org.apache.jsp.tag.web.Header_tag _jspx_th_h_Header_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.Header_tag.class) : new org.apache.jsp.tag.web.Header_tag();
    _jspx_th_h_Header_0.setJspContext(_jspx_page_context);
    _jspx_th_h_Header_0.doTag();
    return false;
  }

  private boolean _jspx_meth_h_Footer_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:Footer
    org.apache.jsp.tag.web.Footer_tag _jspx_th_h_Footer_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(org.apache.jsp.tag.web.Footer_tag.class) : new org.apache.jsp.tag.web.Footer_tag();
    _jspx_th_h_Footer_0.setJspContext(_jspx_page_context);
    _jspx_th_h_Footer_0.doTag();
    return false;
  }
}
