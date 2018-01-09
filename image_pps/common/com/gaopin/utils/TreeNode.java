/* This file TreeNode.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

/**
 * 树节点
  *<dl>
  *<dt>类名：TreeNode</dt>
  *<dd>公司: 炫果壳(北京)信息技术有限公司</dd>
  *<dd>创建时间：2012-5-2  上午10:20:54</dd>
  *<dd>创建人： fming</dd>
  *</dl>
 */
public class TreeNode {
	
	public TreeNode(String id, String text, boolean leaf, String imageScale) {
		this.id = id;
		this.text = text + "["+id+"]";
		this.leaf = leaf;
		this.imageScale = imageScale;
	}
	
	//节点编码
	private String id;
	
	//节点显示
	private String text;
	
	private boolean leaf;
	
	private String imageScale;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getImageScale() {
		return imageScale;
	}

	public void setImageScale(String imageScale) {
		this.imageScale = imageScale;
	}

}
