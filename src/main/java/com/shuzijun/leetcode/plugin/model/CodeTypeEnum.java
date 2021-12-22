package com.shuzijun.leetcode.plugin.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuzijun
 */
public enum CodeTypeEnum {
    JAVA("Java", "java", ".java", "//", "/**\n%s\n*/"),
    PYTHON("Python", "python", ".py", "# ","\"\"\"\n%s\n\"\"\""),
    CPP("C++", "cpp", ".cpp", "//", "/**\n%s\n*/"),
    PYTHON3("Python3", "python3", ".py", "# ","\"\"\"\n%s\n\"\"\""),
    C("C", "c", ".c", "//", "/**\n%s\n*/"),
    CSHARP("C#", "csharp", ".cs", "//", "/**\n%s\n*/"),
    JAVASCRIPT("JavaScript", "javascript", ".js", "//", "/**\n%s\n*/"),
    RUBY("Ruby", "ruby", ".rb", "#","=begin\n%s\n=end"),
    SWIFT("Swift", "swift", ".swift", "///", "/**\n%s\n*/"),
    GO("Go", "golang", ".go", "//", "/**\n%s\n*/"),
    SCALA("Scala", "scala", ".scala", "//", "/**\n%s\n*/"),
    KOTLIN("Kotlin", "kotlin", ".kt", "//", "/**\n%s\n*/"),
    RUST("Rust", "rust", ".rs", "//", "/**\n%s\n*/"),
    PHP("PHP", "php", ".php", "//", "/**\n%s\n*/"),
    BASH("Bash", "bash", ".sh", "#",": '\n%s\n'"),
    MYSQL("MySQL", "mysql", ".sql", "#", "/**\n%s\n*/"),
    ORACLE("Oracle", "oraclesql", ".sql", "#", "/**\n%s\n*/"),
    MSSQLSERVER("MS SQL Server", "mssql", ".sql", "#", "/**\n%s\n*/"),
    TypeScript("TypeScript", "typescript", ".ts", "//", "/**\n%s\n*/"),
    ;

    private final String template = "from typing import *\n\n\n";
    private final String type;
    private final String langSlug;
    private final String suffix;
    private final String comment;
    private final String multiLineComment;

    CodeTypeEnum(String type, String langSlug, String suffix, String comment, String multiLineComment) {
        this.type = type;
        this.langSlug = langSlug;
        this.suffix = suffix;
        this.comment = comment;
        this.multiLineComment = multiLineComment;
    }

    private static Map<String, CodeTypeEnum> MAP = new HashMap<String, CodeTypeEnum>();
    private static Map<String, CodeTypeEnum> LANGSLUGMAP = new HashMap<String, CodeTypeEnum>();

    static {
        for (CodeTypeEnum c : CodeTypeEnum.values()) {
            MAP.put(c.getType().toUpperCase(), c);
            LANGSLUGMAP.put(c.langSlug.toUpperCase(), c);
        }
    }

    public String getType() {
        return type;
    }

    public String getSuffix() {
        return suffix;
    }

    public static CodeTypeEnum getCodeTypeEnum(String type) {
        return MAP.get(type.toUpperCase());
    }

    public static CodeTypeEnum getCodeTypeEnumByLangSlug(String langSlug) {
        return LANGSLUGMAP.get(langSlug.toUpperCase());
    }

    public String getComment() {
        return comment;
    }

    public String getTemplate() {
        return template;
    }

    public String getMultiLineComment() {
        return multiLineComment;
    }
}
