package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList<String> _jspx_nested = null;
    java.util.ArrayList<String> _jspx_at_begin = null;
    java.util.ArrayList<String> _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();

    try {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam['Root']}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("styles/img/favicon.ico\"/>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"This is faculty portal for DDU\">\n");
      out.write("    <meta name=\"author\" content=\"DDU student\">\n");
      out.write("\n");
      out.write("    <title>Faculty Portal</title>\n");
      out.write("\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam['Root']}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("styles/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam['Root']}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("styles/js/jquery.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam['Root']}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("styles/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam['Root']}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("styles/css/sb-admin-2.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam['Root']}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("styles/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam['Root']}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("styles/metisMenu/metisMenu.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam['Root']}", java.lang.String.class, (PageContext)this.getJspContext(), null));
      out.write("styles/js/sb-admin-2.js\"></script>\n");
      out.write("    <style>\n");
      out.write("        \n");
      out.write("        .navbar-default{\n");
      out.write("            background-color: #404040;\n");
      out.write("        }\n");
      out.write("        #wrapper{\n");
      out.write("            background-color: #404040;\n");
      out.write("        }\n");
      out.write("        #wrapper .foot{\n");
      out.write("            color:white !important;\n");
      out.write("        }\n");
      out.write("        #wrapper .foot > a{\n");
      out.write("            color:yellow !important;\n");
      out.write("        }\n");
      out.write("        .nav > li > a:hover{\n");
      out.write("            background-color: #808080;\n");
      out.write("        }\n");
      out.write("        .nav > li > a:active{\n");
      out.write("            background-color: black;\n");
      out.write("        }\n");
      out.write("        .nav > li > a{\n");
      out.write("            font-size: medium;\n");
      out.write("            color: #1ac6ff;\n");
      out.write("        }\n");
      out.write("        .navbar-default .navbar-brand{\n");
      out.write("            color:orangered; \n");
      out.write("            font-size: xx-large;\n");
      out.write("            font-family: algerian,casteller,elephant;\n");
      out.write("        }\n");
      out.write("        .navbar-default .navbar-brand:hover{\n");
      out.write("            color:red; \n");
      out.write("        }\n");
      out.write("        #span-logo{\n");
      out.write("            color:#f2f2f2;\n");
      out.write("        }\n");
      out.write("        #span-logo:hover{\n");
      out.write("            color:white;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("    font-weight: normal !important;\n");
      out.write("}\n");
      out.write("    </style>");
    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
    }
  }
}
