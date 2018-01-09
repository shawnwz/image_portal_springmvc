package com.gaopin.web.controller.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.entity.DownloadHistory;
import com.gaopin.entity.DownloadOrder;
import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.Photographer;
import com.gaopin.entity.PpsEntity;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.VirtualCd;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.ImageCategoryService;
import com.gaopin.service.pps.ImageGroupService;
import com.gaopin.service.pps.IndexPageService;
import com.gaopin.service.pps.LightBoxService;
import com.gaopin.service.pps.PhotographerService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.service.pps.VirtualCdService;
import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.controller.BaseController;

@Controller
public class PageController extends BaseController {

	@Resource
	private ImageCategoryService imageCategoryService;
	@Resource
	private CollectionService collectionService;
	@Resource
	private PhotographerService photographerService;
	@Resource
	private VirtualCdService virtualCdService;
	@Resource
	private SearchService searchService;
	@Resource
	private LightBoxService lightBoxService;
	@Resource
	private IndexPageService indexPageService;
	@Resource
	private ImageGroupService imageGroupService;
	@Resource
	private VariablesService variablesService;

	@RequestMapping(value = { "/photographer{pname}", "/photographer/{pname}" })
	public String photographer(HttpServletRequest request, ModelMap modelMap,
			String pname) {
		pname = getStringValue(request, "pname", "");
		Photographer pg = photographerService.getByName(pname);
		if (StrUtils.isNumeric(pname))
			pg = photographerService.get(Integer.parseInt(pname));

		if (pg == null)
			pg = photographerService.getByNameOrShowName(pname);

		// if(pg!=null)
		// {
		// modelMap.addAttribute("curitem",pg);
		// Map<String,Object> map= searchService
		// .getByPhotographerName(StrUtils.urlEncode(pg.getName(), "utf-8") , 1,
		// 100);
		// modelMap.addAttribute("map",(List<PreviewImageInfo>)(map.get("data")));
		//
		// String[]
		// cidsStrings=(pg.getTemplate()==null?"":pg.getTemplate()).trim().split(",");
		// List<PreviewImageInfo> list=
		// searchService.getPreviewListByCorbisIds(cidsStrings);
		// if(list==null||list.size()==0)
		// list=(List<PreviewImageInfo>)(searchService
		// .getByPhotographerName(StrUtils.urlEncode(pg.getName(), "utf-8") , 1,
		// 5).get("data"));
		//
		// modelMap.addAttribute("covers",list);
		// }
		try {
			JSONObject jsonObject = JSONObject.fromObject(pg.getTemplate());
			String phIds = jsonObject.get("phIds").toString();
			int count = 0;
			Map<String, String> map = new HashMap<String, String>();
			Map<String, String> mapCount = new HashMap<String, String>();
			if (StrUtils.isBlank(phIds)) {
				phIds = variablesService.getVariablesValue(
						"flow_photographer_ids", "");
			}
			if (!StrUtils.isBlank(phIds)) {
				String[] ids = phIds.split("\\|");
				Integer i = 0;
				for (String id : ids) {
					Photographer ph = photographerService.get(Integer
							.parseInt(id));

					JSONObject jobj = JSONObject.fromObject(pg.getTemplate());
					String cover = jsonObject.get("srcCover").toString();
					map.put(ph.getId().toString(), ph.getName() + "|" + cover);
					mapCount.put(i.toString(), ph.getId().toString());
					i++;
				}
				count = ids.length;
			} else {

			}

			modelMap.addAttribute("curitem", pg);
			modelMap.addAttribute("count", count);
			modelMap.addAttribute("listMap", JsonFormat.toString(mapCount));
			modelMap.addAttribute("phMap", JsonFormat.toString(map));
		} catch (Exception e) {

		}
		if (StrUtils.isBlank(pg.getTemplate())) {
			modelMap.addAttribute("template", "null");
		} else {
			modelMap.addAttribute("template", pg.getTemplate());
		}
		modelMap.addAttribute("name", pg == null ? "" : pg.getName());

		return "/photographer/photographerDetail";
	}

	/*
	 * 一个显示图库，前台就一个页面。
	 */
	@RequestMapping(value = { "/photocollection{pname}",
	"/photocollection/{pname}" })
	public String photocollection(HttpServletRequest request,
			ModelMap modelMap, @PathVariable String pname) {
		ImageCollection item = collectionService.getCollection(pname);
		if (item != null) {
			modelMap.addAttribute("curitem", item);
			modelMap.addAttribute("id", item.getId());
			if (StrUtils.isBlank(item.getTemplate())) {
				modelMap.addAttribute("template", "null");
			} else {
				modelMap.addAttribute("template", item.getTemplate());
			}

			int count = 0;
			if (!StrUtils.isBlank(item.getTemplate())) {
				JSONObject jsonObject = JSONObject.fromObject(item
						.getTemplate());
				String phIds = jsonObject.get("tags").toString();
				if (!StrUtils.isBlank(phIds)) {
					try {

						Map<String, String> map = new HashMap<String, String>();
						String[] ids = phIds.split("\\|");
						Integer i = 0;
						for (String id : ids) {
							Photographer ph = photographerService.get(Integer
									.parseInt(id));
							map.put(i.toString(), ph.getName());
							// JSONObject jobj =
							// JSONObject.fromObject(pg.getTemplate());
							// String cover = jsonObject.get( "srcCover"
							// ).toString();
							// map.put(ph.getId().toString(),
							// ph.getName()+"|"+cover);
							// mapCount.put(i.toString(),ph.getId().toString());
							i++;
						}

						count = ids.length;
						modelMap.addAttribute("phMap", JsonFormat.toString(map));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			modelMap.addAttribute("count", count);

			// Map<String,Object> map=
			// searchService.getByCollectionId(item.getId(), 1, 100);
			// modelMap.addAttribute("map",(List<PreviewImageInfo>)(map.get("data")));
			// List<PreviewImageInfo> covers=new ArrayList<PreviewImageInfo>();
			// String coverString=item.getCoverUrl();
			// if(StrUtils.isBlank(coverString))
			// {
			// covers=(List<PreviewImageInfo>)(searchService.getByCollectionId(item.getId(),
			// 1, 5).get("data"));
			// }else {
			// covers=searchService.getPreviewListByCorbisIds(coverString.trim().split(","));
			// }
			// modelMap.addAttribute("covers",covers);
		}
		modelMap.addAttribute("name", pname);
		modelMap.addAttribute("title", "图 库" + pname);
		return "/imageCollection/imageCollectionDetail";
	}

	@RequestMapping(value = "/getPhotocollectionList")
	@ResponseBody
	public Map<String, Object> getPhotocollectionList(HttpServletRequest request) {
		Map<String, Object> message = new HashMap<String, Object>();
		int p = Integer.parseInt(StrUtils.getNullStr(request.getParameter("p"),
				"1")) - 1;
		int ps = Integer.parseInt(StrUtils.getNullStr(
				request.getParameter("ps"), "9"));
		// int
		// type=Integer.parseInt(StrUtils.getNullStr(request.getParameter("type"),"0"));

		String typeSearch = getStringValue(request, "type", "");
		try {

			Collection<HibernateExpression> coll = new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("parentId", 0, CompareType.Equal));
			coll.add(new CompareExpression("status", 0, CompareType.Equal));
			if (!typeSearch.isEmpty()) {
				coll.add(new CompareExpression("pricingTier", typeSearch,
						CompareType.Equal));
			}
			// data
			List<ImageCollection> list = baseService.getController().findBy(
					ImageCollection.class, p, ps, "sortId", false, coll);

			// dataCount
			long entityCount = baseService.getController().getResultCount(
					ImageCollection.class, coll);
			long count = entityCount % ps == 0 ? entityCount / ps : entityCount
					/ ps + 1;

			// List<String> ids = new ArrayList<String>();
			// for (DownloadHistory lbr : list) {
			// ids.add(lbr.getCorbisId());
			// }
			// List<PreviewImageInfo> lightsValue = new
			// ArrayList<PreviewImageInfo>();
			// lightsValue = searchService.getPreviewListSplashEnable(ids);
			// Map<String, PreviewImageInfo> map = new HashMap<String,
			// PreviewImageInfo>();
			// for (PreviewImageInfo preview : lightsValue) {
			// map.put(preview.getCorbisId(), preview);
			// }
			// message.put("map", map);
			message.put("data", list);
			message.put("pageCount", count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return message;
	}

	@RequestMapping(value = { "/photocollectionList", "/photocollection/List" })
	public String photocollectionList(HttpServletRequest request,
			ModelMap modelMap) {

		// 右下
		PpsEntity objEntity = variablesService
				.getPpsEntityValue("flow_collectionLanding_tag");
		modelMap.put("title", objEntity.getTitle());
		modelMap.put("info", objEntity.getInfo());
		modelMap.put("url", objEntity.getUrl());

		// 右上
		PpsEntity objUp = variablesService
				.getPpsEntityValue("flow_collectionLanding_name");
		modelMap.put("upName", objUp.getTitle());
		modelMap.put("upUrl", objUp.getUrl());

		// 上图
		String upImage = variablesService.getVariablesValue(
				"flow_collectionLanding_image_detail", "");
		modelMap.put("upImage", upImage);

		// 下图
		String downImage = variablesService.getVariablesValue(
				"flow_collectionLanding_image", "");
		modelMap.put("downImage", downImage);

		return "/imageCollection/imageCollectionList";
	}

	@RequestMapping(value = { "/photogroup{id}", "/photogroup/{id}" })
	public String photogroup(HttpServletRequest request, ModelMap modelMap,
			@PathVariable String id) {

		// ImageGroup group=

		modelMap.addAttribute("title", "图 片组" + id);
		return "/page/photogroup";
	}

	/*
	 * 分类页面，rmrf。。。etc. 输入为catid , or indexmenuid .
	 */
	@RequestMapping(value = { "/photostock{catid}", "/photostocks/{catid}",
	"/photostock/{catid}" })
	public String photostock(HttpServletRequest request, ModelMap modelMap,
			@PathVariable Integer catid) {
		if (catid == 659) {
			modelMap.addAttribute("item1", variablesService
					.getPpsEntityValue("flow_creativeLanding_1_indeximage"));
			modelMap.addAttribute("item5", variablesService
					.getPpsEntityValue("flow_creativeLanding_5_imageset"));
			modelMap.addAttribute("item6", variablesService
					.getPpsEntityValue("flow_creativeLanding_6_imageset"));
			modelMap.addAttribute("item7", variablesService
					.getPpsEntityValue("flow_creativeLanding_7_imageset"));
			modelMap.addAttribute("item8", variablesService
					.getPpsEntityValue("flow_creativeLanding_8_imageset"));
			modelMap.addAttribute("item9", variablesService
					.getPpsEntityValue("flow_creativeLanding_9_imageset"));
			modelMap.addAttribute("item10", variablesService
					.getPpsEntityValues("flow_creativeLanding_10_collections"));
		} else if (catid == 662) {
			modelMap.addAttribute("item2", variablesService
					.getPpsEntityValue("flow_creativeRF_2_indeximage"));
			modelMap.addAttribute("item31", variablesService
					.getPpsEntityValue("flow_creativeRF_3_prod_1"));
			modelMap.addAttribute("item32", variablesService
					.getPpsEntityValue("flow_creativeRF_3_prod_2"));
			modelMap.addAttribute("item33", variablesService
					.getPpsEntityValue("flow_creativeRF_3_prod_3"));
			modelMap.addAttribute("item5", variablesService
					.getPpsEntityValue("flow_creativeRF_5_imageset"));
			modelMap.addAttribute("item4", variablesService
					.getPpsEntityValue("flow_creativeRF_4_collection"));

			modelMap.addAttribute("item4l", variablesService
					.getPpsEntityValue("flow_creativeRF_4_link"));
			modelMap.addAttribute("item5l", variablesService
					.getPpsEntityValue("flow_creativeRF_5_link"));

			modelMap.addAttribute("item4s", variablesService
					.getPpsEntityValues("flow_creativeRF_4_collection_imgs"));
			modelMap.addAttribute("item6s", variablesService
					.getPpsEntityValues("flow_creativeRF_6_type"));
		} else if (catid == 660) {
			modelMap.addAttribute("item2", variablesService
					.getPpsEntityValue("flow_creativeRM_2_indeximage"));
			modelMap.addAttribute("item31", variablesService
					.getPpsEntityValue("flow_creativeRM_3_prod_1"));
			modelMap.addAttribute("item32", variablesService
					.getPpsEntityValue("flow_creativeRM_3_prod_2"));
			modelMap.addAttribute("item5", variablesService
					.getPpsEntityValue("flow_creativeRM_5_imageset"));
			modelMap.addAttribute("item4", variablesService
					.getPpsEntityValue("flow_creativeRM_4_collection"));

			modelMap.addAttribute("item4s", variablesService
					.getPpsEntityValues("flow_creativeRM_4_collection_imgs"));
			modelMap.addAttribute("item6s", variablesService
					.getPpsEntityValues("flow_creativeRM_6_collections"));

			modelMap.addAttribute("item4l", variablesService
					.getPpsEntityValue("flow_creativeRM_4_link"));
			modelMap.addAttribute("item5l", variablesService
					.getPpsEntityValue("flow_creativeRM_5_link"));
			modelMap.addAttribute("item6l", variablesService
					.getPpsEntityValue("flow_creativeRM_6_link"));
		} else if (catid == 661) {
			modelMap.addAttribute("item2", variablesService
					.getPpsEntityValue("flow_editorialLanding_2_index"));
			modelMap.addAttribute("item3", variablesService
					.getPpsEntityValue("flow_editorialLanding_3_coll"));
			modelMap.addAttribute("item4", variablesService
					.getPpsEntityValue("flow_editorialLanding_4_coll"));
			modelMap.addAttribute("item5", variablesService
					.getPpsEntityValue("flow_editorialLanding_5_coll"));
			modelMap.addAttribute("item6", variablesService
					.getPpsEntityValue("flow_editorialLanding_6_coll"));
			modelMap.addAttribute("item3t", variablesService
					.getPpsEntityValue("flow_editorialLanding_3_tag"));
			modelMap.addAttribute("item4t", variablesService
					.getPpsEntityValue("flow_editorialLanding_4_tag"));
			modelMap.addAttribute("item5t", variablesService
					.getPpsEntityValue("flow_editorialLanding_5_tag"));
			modelMap.addAttribute("item6t", variablesService
					.getPpsEntityValue("flow_editorialLanding_6_tag"));
		} else if (catid == 682) // entainment sub-category
		{
			// banner
			modelMap.addAttribute("item_banner", variablesService
					.getPpsEntityValue("flow_entertainment_banner"));

			// search bar
			modelMap.addAttribute("item_searchbar", variablesService
					.getPpsEntityValue("flow_entertainment_searchbar"));

			// image section: overview
			modelMap.addAttribute("item_ovewview", variablesService
					.getPpsEntityValue("flow_entertainment_overview"));

			// image section: biger
			modelMap.addAttribute("item_img_big1", variablesService
					.getPpsEntityValue("flow_entertainment_img_big1"));
			modelMap.addAttribute("item_img_big2", variablesService
					.getPpsEntityValue("flow_entertainment_img_big2"));
			modelMap.addAttribute("item_img_big3", variablesService
					.getPpsEntityValue("flow_entertainment_img_big3"));
			modelMap.addAttribute("item_img_big4", variablesService
					.getPpsEntityValue("flow_entertainment_img_big4"));

			// image section: smaller
			modelMap.addAttribute("item_img_small1", variablesService
					.getPpsEntityValue("flow_entertainment_img_small1"));
			modelMap.addAttribute("item_img_small2", variablesService
					.getPpsEntityValue("flow_entertainment_img_small2"));
			modelMap.addAttribute("item_img_small3", variablesService
					.getPpsEntityValue("flow_entertainment_img_small3"));
		} else if (catid == 680) // art sub-category
		{
			// banner
			modelMap.addAttribute("item_banner",
					variablesService.getPpsEntityValue("flow_art_banner"));

			// search bar
			modelMap.addAttribute("item_searchbar",
					variablesService.getPpsEntityValue("flow_art_searchbar"));

			// image section: overview
			modelMap.addAttribute("item_overview",
					variablesService.getPpsEntityValue("flow_art_overview"));

			// image section:
			modelMap.addAttribute("item_img_1",
					variablesService.getPpsEntityValue("flow_art_img_1"));
			modelMap.addAttribute("item_img_2",
					variablesService.getPpsEntityValue("flow_art_img_2"));
			modelMap.addAttribute("item_img_3",
					variablesService.getPpsEntityValue("flow_art_img_3"));
			modelMap.addAttribute("item_img_4",
					variablesService.getPpsEntityValue("flow_art_img_4"));
			modelMap.addAttribute("item_img_5",
					variablesService.getPpsEntityValue("flow_art_img_5"));
		} else if (catid == 691) // documentary sub-category
		{
			// banner
			modelMap.addAttribute("item_banner", variablesService
					.getPpsEntityValue("flow_documentary_banner"));

			// search bar
			modelMap.addAttribute("item_searchbar", variablesService
					.getPpsEntityValue("flow_documentary_searchbar"));

			// image section: overview
			modelMap.addAttribute("item_overview", variablesService
					.getPpsEntityValue("flow_documentary_overview"));

			// image section:
			modelMap.addAttribute("item_img_1", variablesService
					.getPpsEntityValue("flow_documentary_img_1"));
			modelMap.addAttribute("item_img_2", variablesService
					.getPpsEntityValue("flow_documentary_img_2"));
			modelMap.addAttribute("item_img_3", variablesService
					.getPpsEntityValue("flow_documentary_img_3"));
			modelMap.addAttribute("item_img_4", variablesService
					.getPpsEntityValue("flow_documentary_img_4"));
			modelMap.addAttribute("item_img_5", variablesService
					.getPpsEntityValue("flow_documentary_img_5"));
		} else if (catid == 666) // historical sub-category
		{
			// banner
			modelMap.addAttribute("item_banner", variablesService
					.getPpsEntityValue("flow_historical_banner"));

			// search bar
			modelMap.addAttribute("item_searchbar", variablesService
					.getPpsEntityValue("flow_historical_searchbar"));

			// image section: overview
			modelMap.addAttribute("item_overview", variablesService
					.getPpsEntityValue("flow_historical_overview"));

			// image section:
			modelMap.addAttribute("item_img_1",
					variablesService.getPpsEntityValue("flow_historical_img_1"));
			modelMap.addAttribute("item_img_2",
					variablesService.getPpsEntityValue("flow_historical_img_2"));
			modelMap.addAttribute("item_img_3",
					variablesService.getPpsEntityValue("flow_historical_img_3"));
			modelMap.addAttribute("item_img_4",
					variablesService.getPpsEntityValue("flow_historical_img_4"));
		}

		else if (catid == 761) {  //automobile background
			System.out.println("in 761");
			// banner
			modelMap.addAttribute("item_banner", variablesService.getPpsEntityValue("automobile_background_banner"));

			// search bar
			modelMap.addAttribute("item_searchbar", variablesService.getPpsEntityValue("automobile_background_search_bar"));

			// section one
			PpsEntity entityCount = variablesService.getPpsEntityValue("automobile_background_one_title_count");
			String[] arrayTitleCount = entityCount.getTitle().split("-");
			int titleCountNumber = arrayTitleCount.length;
			modelMap.addAttribute("titleCount", titleCountNumber);

			List<String[]> itemList = new ArrayList<String[]>();
			List<String> itemListTitle=new ArrayList<String>();
			for (int i = 1; i < arrayTitleCount.length + 1; i++) {
				PpsEntity ppsEntityValue = variablesService.getPpsEntityValue("automobile_background_one_" + i);
				String[] itemArrayList =ppsEntityValue.getSrc().split("-");
				//itemTitle
				String itemTitle =ppsEntityValue.getTitle().toString();
				itemListTitle.add(itemTitle);
				//itemName
				itemList.add(itemArrayList);
			}
			modelMap.addAttribute("item_section_one", itemList);
			modelMap.addAttribute("item_section_one_countTilte",itemListTitle);
			
			// section two
			modelMap.addAttribute("item_section_two", variablesService.getPpsEntityValue("automobile_background_section_two"));

			// section three
			PpsEntity entityThree = variablesService.getPpsEntityValue("automobile_background_section_three");
			String[] arrayList = entityThree.getSrc().split("-");
			modelMap.addAttribute("item_section_three_imgbig", arrayList[0]);

			final int IMG_COUNT_PER_PAGE = 9;
			String[] arrList = new String[IMG_COUNT_PER_PAGE];
			for (int i = 0; i < arrList.length; i++) {
				arrList[i] = arrayList[i + 1];
			}
			modelMap.addAttribute("item_section_three_imgsmall", arrList);

			// section four
			modelMap.addAttribute("item_section_four", variablesService.getPpsEntityValue("automobile_background_four"));

			// section five
			modelMap.addAttribute("item_section_five", variablesService.getPpsEntityValue("automobile_background_five"));
		}
		else if(catid ==778){//Dynamic figure yummy image
			//one text
			modelMap.addAttribute("dynamic_background_sectionOne_text",variablesService.getPpsEntityValue("dynamic_background_sectionOne_text"));
			//banner
			modelMap.addAttribute("dynamic_background_banner", variablesService.getPpsEntityValue("dynamic_background_banner"));
			PpsEntity entityValue = variablesService.getPpsEntityValue("dynamic_background_sectionOne_context");
			String[] itemImageList=  entityValue.getSrc().split("-");
			for (int i = 0; i < itemImageList.length; i++) {
				logger.getLogger(PageController.class).info(itemImageList[i]);
			}
			modelMap.addAttribute("sectionOne_context_picture",itemImageList);
			modelMap.addAttribute("sectionOne_context_title",entityValue.getTitle());
			
			//bottom 
			PpsEntity ent = variablesService.getPpsEntityValue("dynamic_background_bottom");
			String[] itemImage=  ent.getSrc().split("-");
			modelMap.addAttribute("dynamic_background_bottom_img",itemImage);
			modelMap.addAttribute("dynamic_background_bottom",ent);
			

		}
		if (catid != 660 && catid != 661 && catid != 662 && catid != 659
				&& catid != 682 && catid != 680 && catid != 691 && catid != 666
				&& catid != 761 && catid !=778)
			return "/page/photostock";
		return "/page/photostock" + catid.toString();
	}

	@RequestMapping(value = { "/cd{pname}", "/cd/{pname}" })
	public String cd(HttpServletRequest request, ModelMap modelMap,
			@PathVariable String pname) {
		VirtualCd cd = virtualCdService.getByName(pname);
		modelMap.addAttribute("item", cd);
		modelMap.addAttribute("name", pname);
		// 差一个list
		modelMap.addAttribute("title", "CD" + pname);
		return "/page/cd";
	}

	@RequestMapping(value = "/trends")
	public String trends(HttpServletRequest request, ModelMap modelMap) {
		return "/page/trends";
	}

	@RequestMapping(value = "/portfouo")
	public String portfouo(HttpServletRequest request, ModelMap modelMap) {
		return "/page/portfouo";
	}

	@RequestMapping(value = "/ondemand")
	public String ondemand(HttpServletRequest request, ModelMap modelMap) {
		return "/page/ondemand";
	}

}
