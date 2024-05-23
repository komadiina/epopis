package org.unibl.etf.epopis.db.querying;

import java.lang.reflect.Field;
import java.util.*;

public class StatementEngine<T> {
    public String generateSelectAll(T obj) {
        String query = String.format("SELECT * FROM %s", obj.getClass().getSimpleName().toLowerCase());
        System.out.println(query);

        return query;
    }

    public String generateSelect(T obj) {
        String query = String.format("SELECT * FROM %s WHERE %s = %s",
                obj.getClass().getSimpleName().toLowerCase(),
                stripPrefixes(getPrimaryKeyField(obj)),
                getFieldValue(obj, getPrimaryKeyField(obj)) // TODO: implement setting primary key on <T> object
        );

        System.out.println(query);
        return query;
    }

    public String generateUpdate(T obj, Object id) {
        if (id == null) {
            id = getFieldValue(obj, getPrimaryKeyField(obj));
        }

        // MySQL allows integer types to be encapsulated in quotes, wow
        // TODO possibly hotfix this when shit breaks
        // if (id instanceof String)
        //      id = reassureFormatting((String)id);

        String query = String.format("UPDATE %s SET %s WHERE %s = '%s'",
                obj.getClass().getSimpleName().toLowerCase(),                            // entity table
                stripPrefixes(getAssignedFieldValues(obj, false)),       // formatted values
                stripPrefixes(getPrimaryKeyField(obj)),                                 // primary key name
                id                                                                      // primary key value
        );
        System.out.println(query);

        return query;
    }

    public String generateInsert(T obj) {
        Class<?> c = obj.getClass();
        String query = String.format("INSERT INTO %s (%s) VALUES (%s)",
                c.getSimpleName().toLowerCase(),
                formatSQLQueryValues(
                        getFieldNames(obj)
                ),
                formatSQLQueryValues(
                        getFieldValues(obj)
                )
        );
        System.out.println(query);

        return query;
    }

    public String generateDelete(T obj) {
        Class<?> c = obj.getClass();

        String query = String.format("DELETE FROM %s WHERE ('%s' = %s)",
                c.getSimpleName().toLowerCase(),
                stripPrefixes(getAssignedFieldValues(obj, false)),
                stripPrefixes(getPrimaryKeyField(obj))
        ); // TODO

        System.out.println(query);

        return query;
    }

    public String getPrimaryKeyField(T obj) {
        String pkField = null;
        Class<?> c = obj.getClass();

        for (Field f : c.getDeclaredFields())
            if (f.getName().startsWith("pk_"))
                pkField = f.getName();

        return pkField;
    }

    public List<String> getForeignKeyFields(T obj) {
        List<String> fkFields = new ArrayList<>();
        Class<?> c = obj.getClass();

        for (Field f : c.getDeclaredFields())
            if (f.getName().startsWith("fk_"))
                fkFields.add(f.getName());

        return fkFields;
    }

    public List<String> getFieldNames(T obj) {
        List<String> fieldNames = new ArrayList<>();
        Class<?> c = obj.getClass();

        for (Field f : c.getDeclaredFields())
            fieldNames.add(f.getName());

        return fieldNames;
    }

    public List<String> getFieldValues(T obj) {
        List<String> values = new ArrayList<>();
        Class<?> c = obj.getClass();

        for (Field f : c.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object value = f.get(obj);
                if (value instanceof String)
                    value = String.format("\"%s\"", value);

                values.add(value == null ? "null" : value.toString());
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }

        return values;
    }

    public String getFieldValue(T obj, String fieldName) {
        List<String> fieldNames = getFieldNames(obj);
        List<String> fieldValues = getFieldValues(obj);

        for (int i = 0; i < fieldNames.size(); i++)
            if (fieldNames.get(i).equals(fieldName))
                return fieldValues.get(i);

        return "null";
    }

    public String getAssignedFieldValues(T obj, boolean includePrimaryKey) {
        List<String> fieldNames = getFieldNames(obj);
        StringJoiner joiner = new StringJoiner(", ");

        for (String fieldName : fieldNames)
            if (!(!includePrimaryKey && fieldName.equals(getPrimaryKeyField(obj))))
                joiner.add(String.format("%s=%s", fieldName, getFieldValue(obj, fieldName)));

        return joiner.toString();
    }

    public String formatSQLQueryValues(List<String> values) {
        StringJoiner joiner = new StringJoiner(", ");
        List<String> deprefixed = new ArrayList<>();
        for (String val : values)
                deprefixed.add(stripPrefixes(val));
        deprefixed.forEach(joiner::add);
        return joiner.toString();
    }

    private String stripPrefixes(String fieldNames) {
        fieldNames = fieldNames.replaceAll("pk_", "");
        return fieldNames.replaceAll("fk_", "");
    }

    private String reassureFormatting(String id) {
        if (!id.startsWith("\""))
            id = "\"" + id;
        if (!id.endsWith("\""))
            id = id + "\"";

        return id;
    }
}
