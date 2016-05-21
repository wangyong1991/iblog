package com.iblog.support;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FirstTag extends AbstartTagSupport{
  private static final long serialVersionUID = 1L;

  @Override
  public int doStartTag() throws JspException{
    setPageAttribute(1);
    return TagSupport.EVAL_BODY_INCLUDE;
  }

}
