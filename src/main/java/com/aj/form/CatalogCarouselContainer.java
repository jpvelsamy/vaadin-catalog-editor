package com.aj.form;

import com.aj.reusuables.LapDesignTemplate;
import com.aj.reusuables.LeadAcquisitionPage;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CatalogCarouselContainer extends HorizontalLayout {

	private static final long serialVersionUID = -1694750111567168590L;
	private Map<Integer, CatalogItemView> itemMap = new LinkedHashMap<Integer, CatalogItemView>();
	private CarouselItemBuilder carouselItemBuilder;
	private CatalogItemView firstItem;
	private CatalogItemView secondItem;
//	private CatalogItemView thirdItem;
	private LapDesignTemplate template;

	public CatalogCarouselContainer() {

	}

	public void swapTemplate(LapDesignTemplate template) {
		this.template = template;
		carouselItemBuilder = CarouselBuilderFactory.create(this.template);
	}

	public void loadLap(LeadAcquisitionPage lap) {

		Collection<CatalogueItem> itemCollection = lap.getMarketingCard().getCatalogueDetails();

		// For whatever reason the lambda editor is not giving proper intellisense,
		// hence having the below line for that purpose
		// CatalogueItem item2 = itemCollection.iterator().next();

		itemCollection.forEach(item -> {

			CatalogItemView catalogComponent = carouselItemBuilder.build(item);
			itemMap.put(item.getPosition(), catalogComponent);
		});
		final int firstIndex = itemMap.size();
		final ImmutablePair<Integer, Integer> indexTuple = getNewerIndexes(firstIndex);
		updateView(indexTuple);

	}

	public void moveForward() {
		final int nthPosition = this.secondItem.getIndex() + 1;
		final ImmutablePair<Integer, Integer> indexTuple = getOlderIndexes(nthPosition);
		updateView(indexTuple);
	}

	public void moveBackward() {
		final int nthPosition = this.firstItem.getIndex() - 1;
		final ImmutablePair<Integer, Integer> indexTuple = getNewerIndexes(nthPosition);
		updateView(indexTuple);
	}

	public void addNewCard(CatalogueItem newItem) {
		final int size = this.itemMap.size();
		final int newPosition = size + 1;
		CatalogItemView newItemView = this.carouselItemBuilder.buildNewCard(newPosition);
		this.itemMap.put(newPosition, newItemView);
		final ImmutablePair<Integer, Integer> indexTuple = getNewerIndexes(newPosition);
		updateView(indexTuple);
	}

	/**
	 * This is the tricky part, need to think
	 * 
	 * @param removeCandidate
	 */
	public void removeCard(CatalogItemView removeCandidate) {
		Integer index = removeCandidate.getIndex();
		this.itemMap.remove(index, removeCandidate);
	}

	public void updateView(final ImmutablePair<Integer, Integer> indexTuple) {
		Integer firstItemIndex = indexTuple.left;
		Integer secondItemIndex = indexTuple.right;

		if (firstItem == null) {
			firstItem = this.itemMap.get(firstItemIndex);
			if (firstItem != null)
				addComponentAsFirst(firstItem);
			if (secondItem == null) {
				secondItem = this.itemMap.get(secondItemIndex);
				if (secondItem != null)
					addComponentAsFirst(secondItem);
			}
		} else {
			if (this.itemMap.containsKey(firstItemIndex)) {
				CatalogItemView nthItem = this.itemMap.get(firstItemIndex);
				if (nthItem != null) {
					// replace(firstItem, nthItem);
					remove(firstItem);
					firstItem = nthItem;
				}
				if (this.itemMap.containsKey(secondItemIndex)) {
					CatalogItemView nplusOnethItem = this.itemMap.get(secondItemIndex);
					if (nplusOnethItem != null) {
						// replace(secondItem, nplusOnethItem);
						if (secondItem != null)
							remove(secondItem);
						secondItem = nplusOnethItem;
					}
					}
				}
			}
			if (secondItem != null)
				addComponentAsFirst(secondItem);
			if (firstItem != null)
				addComponentAsFirst(firstItem);
		}

	/*public ImmutableTriple<Integer, Integer, Integer> getOlderIndexes(Integer firstItemIndex) {
		final int secondItemIndex = firstItemIndex + 1;
		final int thirdItemIndex = secondItemIndex + 1;
		return new ImmutableTriple<Integer, Integer, Integer>(thirdItemIndex, secondItemIndex, firstItemIndex);
	}*/

	public ImmutablePair<Integer, Integer> getOlderIndexes(Integer firstItemIndex) {
		final int secondItemIndex = firstItemIndex + 1;
		return new ImmutablePair<Integer, Integer>(secondItemIndex, firstItemIndex);
	}

	/*public ImmutableTriple<Integer, Integer, Integer> getNewerIndexes(Integer firstItemIndex) {
		final int secondItemIndex = firstItemIndex - 1;
		final int thirdItemIndex = secondItemIndex - 1;
		return new ImmutableTriple<Integer, Integer, Integer>(firstItemIndex, secondItemIndex, thirdItemIndex);

	}*/

	public ImmutablePair<Integer, Integer> getNewerIndexes(Integer firstItemIndex) {
		final int secondItemIndex = firstItemIndex - 1;
		return new ImmutablePair<Integer, Integer>(firstItemIndex, secondItemIndex);

	}

	public Integer getLastIndex() {
		if (this.secondItem != null) {
			return this.secondItem.getIndex();
		} else {
			return this.itemMap.size();
		}
	}

	public Integer getFirstIndex() {

		return this.firstItem.getIndex();
	}

	public void getNavDisable() {
		if (this.itemMap.size()>1){
			moveBackward();
		}
	}

}
