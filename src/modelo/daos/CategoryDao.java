package modelo.daos;

import modelo.beans.Category;
import java.util.List;

public interface CategoryDao {
	public int insert(Category category);
    public Category findById(int categoryId);
    public List<Category> findAll();
    public int update(Category category);
    public int delete(Category category);
}
