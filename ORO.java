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

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.Perl5Substitution;
import org.apache.oro.text.regex.Util;

/**
 * Jakarta-ORO 是一个Java工具包用来在 Java 类中进行文本处理的功能，提供兼容 Perl5 的正则表达式、类 AWK 的正则表达式等。
 * http://w26.iteye.com/blog/1187322
 */
public class ORO {
    public void usage(String input, String regex) {
        //        private final static Pattern pattern = 
        //new Perl5Compiler().compile("^\\d+$", '''Perl5Compiler.READ_ONLY_MASK''');

        // 1 创建 PatternCompiler
        PatternCompiler compiler = new Perl5Compiler();
        // 2 创建 Pattern
        Pattern pattern = null;
        try {
            /*
             * CASE_INSENSITIVE_MASK : 区分大小写; DEFAULT_MASK : 默认(不区分大小写)
             * EXTENDED_MASK : 支持Perl5 扩展正则表达式 MULTILINE_MASK : 多行匹配，^$匹配每行内容．
             * SINGLELINE_MASK　：单行匹配 ^$匹配全部内容. READ_ONLY_MASK : Perl5Pattern
             * 是只读的，提高性能且线程安全．
             */
            pattern = compiler.compile(regex, Perl5Compiler.READ_ONLY_MASK
                    | Perl5Compiler.MULTILINE_MASK);
        } catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        // 3 创建 PatternMatcher
        PatternMatcher matcher = new Perl5Matcher();
        // 3.1 只匹配一次
        if (matcher.contains(input, pattern)) {
            MatchResult matchResult = matcher.getMatch();
            System.out.println("1st:" + matchResult.toString());
        }
        // 3.2 匹配多次, 使用PatternMatcherInput
        PatternMatcherInput patternMatcherInput = new PatternMatcherInput(input, 0, input.length());
        while (matcher.contains(patternMatcherInput, pattern)) {
            MatchResult matchResult = matcher.getMatch();

            /*
             * System.out.println(matchResult.begin(0)); // 0分组索引 , 匹配串开始值
             * ,如匹配串xxxx xxx, 总是0. System.out.println(matchResult.end(0)); //
             * 0分组索引, 匹配串结束值 , 如xxxxxxx , 则相应值为 4 3.
             * System.out.println(matchResult.beginOffset(0)); //
             * 0分组索引,匹配串在源串开始索引 System.out.println(matchResult.endOffset(0)); //
             * 0分组索引,匹配串在源串结束索引 System.out.println(matchResult.groups()); //
             * 分组数量 System.out.println(matchResult.length()); // 匹配串长度
             * System.out.println(matchResult.toString()); // 匹配串
             */
            String group = matchResult.group(0); // group 是正则表达式里面的()个数, 0// 代表匹配串, 1 代表第一个括号匹配串
            System.out.println("group(0):" + group); // tangliang
            group = matchResult.group(1);
            System.out.println("group(1):" + group); // g
            group = matchResult.group(2);
            System.out.println("group(2):" + group); // g
        }

        // 4 创建替换对象 Substiution
        Perl5Substitution substiution = new Perl5Substitution("amos_tl");
        // 5 文本替换
        String output = Util.substitute(matcher, pattern, substiution, input, Util.SUBSTITUTE_ALL);
        System.out.println("output:" + output); // output:xxxxTangliangxxxamos_tlxxx
    }

    public static void main(String[] args) {
        ORO oro = new ORO();
        oro.usage("xxxxTangliangxxxtangliangxxx", "tan(g)lian(g)");
    }
}
