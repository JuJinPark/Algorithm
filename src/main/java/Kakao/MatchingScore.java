package main.java.Kakao;

import java.util.*;

public class MatchingScore {

    public int solution(String word, String[] pages) {
        Map<String,Page> pageMap = new HashMap<>();
        List<Page> pageList = new ArrayList<>();

        for (int i = 0; i <pages.length ; i++) {
            Page newPage = new Page(pages[i],word,i);
            pageMap.put(newPage.getLinkName(),newPage);
            pageList.add(newPage);
        }

        for (Page page : pageList) {
            List<LinkTag> toLinks = page.getToLinks();
            for (LinkTag toLink : toLinks) {
                String href = toLink.getHref();
                Page to = pageMap.get(href);
                if(to!=null){
                    to.putFromLink(page);
                }

            }
        }

        Collections.sort(pageList,new MatchingValueComparator());
        return pageList.get(0).getIdx();
    }
}
class Page{

    private MetaTag linkNameTag;
    private List<LinkTag>toLinks= new ArrayList<>();
    private List<Page>fromPages = new ArrayList<>();
    private String bodyWithoutTags;
    private int idx;

    private int basicValue;


    public List<LinkTag> getToLinks (){
        return toLinks;
    }

    public void putFromLink(Page page){
        fromPages.add(page);
    }
    public Page(String page,String word,int idx) {
        this.idx=idx;
        this.linkNameTag=findLinkName(page);
        this.toLinks=findToLinks(page);
        this.bodyWithoutTags=setBody(page);
        this.basicValue=getBasicValue(word);

    }

    private int getBasicValue(String word) {
        String pageToFind=bodyWithoutTags.toLowerCase();
        String findStr = word.toLowerCase();
        int lastIndex = 0;
        int count =0;
        while(lastIndex != -1){

            lastIndex = pageToFind.indexOf(findStr,lastIndex);

            if(lastIndex != -1){

                int beforeCharIdx=lastIndex - 1;
                int afterCharIdx=lastIndex +findStr.length();

                if(beforeCharIdx>=0 && afterCharIdx <= pageToFind.length()-1){
                    char beforeChar = pageToFind.charAt(lastIndex - 1);
                    char afterChar = pageToFind.charAt(lastIndex +findStr.length());
                    if(!Character.isLetter(beforeChar) && !Character.isLetter(afterChar)){
                        count++;
                    }
                }

                lastIndex += findStr.length();
            }
        }
        return count;
    }

    private String setBody(String page) {
       return page.replaceAll("<[^>]*>", " ");

    }

    private List<LinkTag> findToLinks(String page) {
        List<LinkTag>toLinks= new ArrayList<>();
        String findStr = "<a";
        int lastIndex = 0;

        while(lastIndex != -1){

            lastIndex = page.indexOf(findStr,lastIndex);

            if(lastIndex != -1){
                String endTag="</a>";
                int endTagIdx=page.indexOf(endTag,lastIndex);
               toLinks.add(new LinkTag(new Tag(page.substring(lastIndex,endTagIdx+endTag.length()))));
                lastIndex += findStr.length();
            }
        }
        return toLinks;

    }

    private MetaTag findLinkName(String page){
        String startLinkNameTag="<meta property=\"og:url\"";
        String endTag="/>";
        int start = page.indexOf(startLinkNameTag);
        int end = page.indexOf(endTag, start);
        return new MetaTag(new Tag(page.substring(start, end+endTag.length())));
    }

    public double getMatchingValue(){
        double totalLinkValue=0;
        for (Page fromLink : fromPages) {
            totalLinkValue+= fromLink.getLinkValue();
        }
        return ((double) this.basicValue)+totalLinkValue;
    }

    private double getLinkValue() {
        return ((double) basicValue)/toLinks.size();
    }


    public String getLinkName(){
        return linkNameTag.getContent();
    }

    public int getIdx() {
        return idx;
    }
}

class MetaTag {
    private Tag tag;

    public MetaTag(Tag tag) {
        this.tag = tag;
    }

    public String getContent(){
        return tag.getAttributeValue("content");
    }
}

class LinkTag {
    private Tag tag;

    public LinkTag(Tag tag) {
        this.tag = tag;
    }

    public String getHref(){
        return tag.getAttributeValue("href");
    }

}

class Tag{
    String text;

    public Tag(String text) {
        this.text = text;
    }

    public String getAttributeValue(String attribute){
        String start=attribute+"=\"";
        String end="\"";
        int startIdx = text.indexOf(start)+start.length();
        int endIdx = text.indexOf(end,startIdx);

        if(startIdx == -1 || endIdx==-1){
            return "";
        }
        String substring = text.substring(startIdx, endIdx);
        return substring;
    }
}

class MatchingValueComparator  implements Comparator<Page> {
    public int compare(Page a, Page b)
    {

        int compare = (Double.compare(a.getMatchingValue(), b.getMatchingValue()))*-1;
        if(compare==0){
            return Integer.compare(a.getIdx(),b.getIdx());
        }
        return compare;

    }
}
