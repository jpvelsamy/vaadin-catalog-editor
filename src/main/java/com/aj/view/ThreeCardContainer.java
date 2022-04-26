package com.aj.view;

import com.aj.form.CatalogueItem;
import com.aj.form.CuteCatalogItemView;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreeCardContainer extends HorizontalLayout {

	private static final long serialVersionUID = -1694750111567168590L;
	private Map<Integer, CuteCatalogItemView> itemMap = new LinkedHashMap<Integer, CuteCatalogItemView>();
	// private final AtomicInteger counter = new AtomicInteger(1);
	private CuteCatalogItemView firstItem;
	private CuteCatalogItemView secondItem;
	private CuteCatalogItemView thirdItem;

	public ThreeCardContainer() {

	}

	public ThreeCardContainer(Collection<CatalogueItem> itemCollection) {
		final AtomicInteger ephCounter = new AtomicInteger(0);
		itemCollection.forEach(item -> {
			int index = ephCounter.getAndIncrement();
			CuteCatalogItemView catalogComponent = new CuteCatalogItemView(item, index);
			itemMap.put(index, catalogComponent);
		});
		final int firstIndex = itemMap.size();
		final ImmutableTriple<Integer, Integer, Integer> indexTuple = getNewerIndexes(firstIndex);
		updateView(indexTuple);

	}

	public void moveForward() {
		final int nthPosition = this.thirdItem.getIndex()+1;
		final ImmutableTriple<Integer, Integer, Integer> indexTuple = getOlderIndexes(nthPosition);
		updateView(indexTuple);
	}

	public void moveBackward() {
		final int nthPosition = this.firstItem.getIndex()-1;
		final ImmutableTriple<Integer, Integer, Integer> indexTuple = getNewerIndexes(nthPosition);
		updateView(indexTuple);
	}

	public void addFirstCard(CuteCatalogItemView newItem) {
		this.itemMap.put(newItem.getIndex(), newItem);
		final ImmutableTriple<Integer, Integer, Integer> indexTuple = new ImmutableTriple<Integer, Integer, Integer>(1,
				0, -1);
		updateView(indexTuple);
	}

	public void addCard(CuteCatalogItemView newItem) {
		final int size = this.itemMap.size();
		final int newPosition = size + 1;
		newItem.setIndex(newPosition);
		this.itemMap.put(newPosition, newItem);
		final ImmutableTriple<Integer, Integer, Integer> indexTuple = getNewerIndexes(newPosition);
		updateView(indexTuple);
	}

	/**
	 * This is the tricky part, need to think
	 * 
	 * @param removeCandidate
	 */
	public void removeCard(CuteCatalogItemView removeCandidate) {
		Integer index = removeCandidate.getIndex();
		this.itemMap.remove(index, removeCandidate);
	}

	public void updateView(final ImmutableTriple<Integer, Integer, Integer> indexTuple) {
		Integer firstItemIndex = indexTuple.left;
		Integer secondItemIndex = indexTuple.middle;
		Integer thirdItemIndex = indexTuple.right;

		if (firstItem == null) {
			firstItem = this.itemMap.get(firstItemIndex);
			if (firstItem != null)
				addComponentAsFirst(firstItem);
			if (secondItem == null) {
				secondItem = this.itemMap.get(secondItemIndex);
				if (secondItem != null)
					addComponentAsFirst(secondItem);

				if (thirdItem == null) {
					thirdItem = this.itemMap.get(thirdItemIndex);
					if (thirdItem != null)
						addComponentAsFirst(thirdItem);
				}
			}
		} else {
			if (this.itemMap.containsKey(firstItemIndex)) {
				CuteCatalogItemView nthItem = this.itemMap.get(firstItemIndex);
				if (nthItem != null) {
					// replace(firstItem, nthItem);
					remove(firstItem);
					firstItem = nthItem;
				}
				if (this.itemMap.containsKey(secondItemIndex)) {
					CuteCatalogItemView nplusOnethItem = this.itemMap.get(secondItemIndex);
					if (nplusOnethItem != null) {
						// replace(secondItem, nplusOnethItem);
						if (secondItem != null)
							remove(secondItem);
						secondItem = nplusOnethItem;
					}
					if (this.itemMap.containsKey(thirdItemIndex)) {
						CuteCatalogItemView nplusTwothItem = this.itemMap.get(thirdItemIndex);
						if (nplusTwothItem != null) {
							// replace(thirdItem, nplusTwothItem);
							if (thirdItem != null)
								remove(thirdItem);
							thirdItem = nplusTwothItem;
						}
					}
				}
			}
			if (thirdItem != null)
				addComponentAsFirst(thirdItem);
			if (secondItem != null)
				addComponentAsFirst(secondItem);
			if (firstItem != null)
				addComponentAsFirst(firstItem);
		}

	}

	public ImmutableTriple<Integer, Integer, Integer> getOlderIndexes(Integer firstItemIndex) {
		final int secondItemIndex = firstItemIndex + 1;
		final int thirdItemIndex = secondItemIndex + 1;
		return new ImmutableTriple<Integer, Integer, Integer>(thirdItemIndex, secondItemIndex, firstItemIndex);
	}

	public ImmutableTriple<Integer, Integer, Integer> getNewerIndexes(Integer firstItemIndex) {
		final int secondItemIndex = firstItemIndex - 1;
		final int thirdItemIndex = secondItemIndex - 1;
		return new ImmutableTriple<Integer, Integer, Integer>(firstItemIndex, secondItemIndex, thirdItemIndex);

	}

	public Integer getLastIndex() {
		if (this.thirdItem != null) {
			return this.thirdItem.getIndex();
		} else {
			return this.itemMap.size();
		}
	}

	public Integer getFirstIndex() {
		return this.firstItem.getIndex();
	}

}
