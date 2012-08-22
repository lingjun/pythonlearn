/**
 * Project: learnsth
 * 
 * File Created at 2012-8-22
 * $Id$
 * 
 * Copyright 1999-2100 Alibaba.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package org.shupeng.learn.tools;

import java.util.ArrayList;

import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.Perl5Substitution;
import org.apache.oro.text.regex.Util;

/**
 * @Description http://oaklet.iteye.com/blog/232969
 * @author shupeng.lisp
 * @date 2012-8-22
 */
public class OroTestDriver {
    /** 查找 */
    public static void simpleContains() throws Exception {
        Pattern pattern = new Perl5Compiler().compile("\\d+");
        Perl5Matcher matcher = new Perl5Matcher();
        PatternMatcherInput matcherInput = new PatternMatcherInput("北京2008年8月08日20时");
        System.out.println("simpleContains:");
        while (matcher.contains(matcherInput, pattern)) {
            MatchResult result = matcher.getMatch();
            System.out.println(result.toString());
        }
    }

    /** 分组 */
    public static void simpleResults() throws Exception {
        Pattern pattern = new Perl5Compiler()
                .compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)@(\\d{2}/\\d{2}/\\d{4})");
        Perl5Matcher matcher = new Perl5Matcher();
        PatternMatcherInput matcherInput = new PatternMatcherInput("202.108.9.38@08/10/2008");
        System.out.println("simpleResults:");
        while (matcher.contains(matcherInput, pattern)) {
            MatchResult result = matcher.getMatch();
            for (int i = 0; i < result.groups(); i++) {
                System.out.printf("%s : %s\n", i, result.group(i));
            }
        }
    }

    /** 拆分 */
    public static void spiltIt() throws Exception {
        String rawStr = "北京;朝阳;鸟巢奥运会场";
        ArrayList<String> results = new ArrayList<String>();
        Perl5Matcher matcher = new Perl5Matcher();
        Pattern pattern = new Perl5Compiler().compile(";");
        Util.split(results, matcher, pattern, rawStr);
        System.out.println("spiltIt:");
        for (String r : results) {
            System.out.println(r);
        }
    }

    /** 替换1 */
    public static void substituteIt() throws Exception {
        String rawStr = "2008-08-11 17:16:32";
        Perl5Matcher matcher = new Perl5Matcher();
        Pattern pattern = new Perl5Compiler().compile("-");
        String result = Util.substitute(matcher, pattern, new Perl5Substitution(","), rawStr,
                Util.SUBSTITUTE_ALL);
        System.out.println("substituteIt:");
        System.out.println(result);
    }

    /** 替换2 */
    public static void substituteIt2() throws Exception {
        String rawStr = "2008-08-11 17:16:32";
        Perl5Matcher matcher = new Perl5Matcher();
        Pattern pattern = new Perl5Compiler()
                .compile("(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}:\\d{2}:\\d{2})");
        String result = Util.substitute(matcher, pattern, new Perl5Substitution("变换 $3,$2,$1 $4"),
                rawStr, Util.SUBSTITUTE_ALL);
        System.out.println("substituteIt2:");
        System.out.println("格式yyyy-MM-dd HH:mm:ss到dd,MM,yyyy HH:mm:ss");
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        simpleContains();
        simpleResults();
        spiltIt();
        substituteIt();
        substituteIt2();
    }
}
