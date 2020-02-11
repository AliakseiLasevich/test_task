package builder;

import org.springframework.stereotype.Component;

@Component
public class SqlQueryBuilder implements QueryBuilder {

    private StringBuilder stringBuilder = new StringBuilder();
    private int limitersCount = 0;

    public SqlQueryBuilder select() {
        stringBuilder.append("SELECT *");
        return this;
    }

    public SqlQueryBuilder update() {
        stringBuilder.append("UPDATE ");
        return this;
    }

    public SqlQueryBuilder delete() {
        stringBuilder.append("DELETE ");
        return this;
    }

    public SqlQueryBuilder fromSourceTable(String source) {
        stringBuilder.append(" FROM " + source);
        return this;
    }

    public SqlQueryBuilder equal(String column, String value) {
        if (limitersCount == 0) {
            stringBuilder.append(" WHERE ");
            limitersCount++;
        }
        stringBuilder.append(column + " = '" + value + "'");
        return this;
    }

    public SqlQueryBuilder and() {
        stringBuilder.append(" AND ");
        return this;
    }

    public SqlQueryBuilder or() {
        stringBuilder.append(" OR ");
        return this;
    }

    public SqlQueryBuilder endWith(String column, String endWith){
        if (limitersCount == 0) {
            stringBuilder.append(" WHERE ");
            limitersCount++;
        }
        stringBuilder.append(column + " LIKE '%" +endWith +"'");
        return this;
    }

    public String build() {
        return stringBuilder.toString();
    }

}
