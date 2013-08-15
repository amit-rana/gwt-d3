/**
 * Copyright (c) 2013, Anthony Schiochet and Eric Citaire
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * The names Anthony Schiochet and Eric Citaire may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL MICHAEL BOSTOCK BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/**
 * 
 */
package com.github.gwtd3.api.svg;

import java.util.List;

import com.github.gwtd3.api.IsFunction;
import com.github.gwtd3.api.JsArrays;
import com.github.gwtd3.api.arrays.Array;
import com.github.gwtd3.api.core.Formatter;
import com.github.gwtd3.api.core.Selection;
import com.github.gwtd3.api.core.Transition;
import com.github.gwtd3.api.functions.DatumFunction;
import com.github.gwtd3.api.scales.LinearScale;
import com.github.gwtd3.api.scales.LogScale;
import com.github.gwtd3.api.scales.OrdinalScale;
import com.github.gwtd3.api.scales.QuantitativeScale;
import com.github.gwtd3.api.scales.Scale;
import com.github.gwtd3.api.time.Interval;
import com.github.gwtd3.api.time.TimeScale;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * D3’s axis component displays reference lines for {@link Scale}s
 * automatically.
 * <p>
 * This lets you focus on displaying the data, while the axis component takes
 * care of the tedious task of drawing axes and labeled ticks.
 * <p>
 * The axis component is designed to work with D3’s {@link QuantitativeScale},
 * {@link TimeScale} and {@link OrdinalScale} scales.
 * <p>
 * 
 * <p>
 * 
 * @author <a href="mailto:schiochetanthoni@gmail.com">Anthony Schiochet</a>
 * @author citaire
 * 
 */
public class Axis extends JavaScriptObject implements IsFunction {

	public static enum Orientation {
		TOP, BOTTOM, LEFT, RIGHT;

		public boolean isVerticalAxis() {
			return (this == LEFT) || (this == RIGHT);
		}

		public boolean isHorizontalAxis() {
			return (this == TOP) || (this == BOTTOM);
		}
	}

	protected Axis() {
	}

	/**
	 * Return the associated scale, which defaults to a linear scale.
	 * 
	 * @return the scale.
	 */
	public final native <S extends Scale<S>> S scale()/*-{
		return this.scale();
	}-*/;

	/**
	 * Set the associated scale.
	 * 
	 * @param the
	 *            scale.
	 * @return the current axis
	 */
	public final native <S extends Scale<S>> Axis scale(S s)/*-{
		return this.scale(s);
	}-*/;

	/**
	 * Returns the current orientation, which defaults to
	 * {@link Orientation#BOTTOM}.
	 * <p>
	 * 
	 * @see #orient(Orientation)
	 * 
	 * @return the current orientation
	 */
	public final native Orientation orient()/*-{
		var o = this.orient().toUpperCase();
		return @com.github.gwtd3.api.svg.Axis.Orientation::valueOf(Ljava/lang/String;)(o);
	}-*/;

	/**
	 * Sets the axis orientation and returns the axis.
	 * <p>
	 * The orientation of an axis is the position of the ticks and their labels
	 * in relation to the axis path.
	 * <p>
	 * For a vertical axis, specify {@link Orientation#LEFT} or
	 * {@link Orientation#RIGHT}; for a horizontal axis, specify
	 * {@link Orientation#TOP} or {@link Orientation#BOTTOM}.
	 * <p>
	 * If instead you want to determine the position of the axis with respect to
	 * the plot, use the transform attribute.
	 * <p>
	 * 
	 * @param o
	 *            the orientation
	 * @return the current axis
	 */
	public final native Axis orient(Orientation o)/*-{
		return this.orient(o.toString().toLowerCase());
	}-*/;

	// ========== ticks methods =========
	/**
	 * Get the arguments that will be passed to the associated scale
	 * {@link Scale#ticks()} method to compute the tick values.
	 * 
	 * @param count
	 * @return the arguments
	 */
	public final native Array<?> ticks()/*-{
		return this.ticks();
	}-*/;

	/**
	 * Specify the argument that will be passed to the associated scale
	 * {@link Scale#ticks()} method to compute the tick values. This version
	 * specify the desired tick count.
	 * <p>
	 * The count parameter is also passed to the
	 * {@link Scale#tickFormat(int, String)} method to generate the default tick
	 * format.
	 * <p>
	 * This version suits for {@link LinearScale} and {@link LogScale}.
	 * <p>
	 * 
	 * @param count
	 *            the argument to be passed to the underlying scale.
	 * @return the current axis
	 */
	public final native Axis ticks(int count)/*-{
		return this.ticks(count);
	}-*/;

	/**
	 * Same as {@link #ticks(int)} but suitable for
	 * {@link LogScale#tickFormat(int, String)}.
	 * 
	 * 
	 * @param count
	 *            the count to be passed to the underlying scale.
	 * @param formatSpecifier
	 *            the format argument to be passed to the underlying scale.
	 * @return the current axis
	 */
	public final native Axis ticks(int count, String formatSpecifier)/*-{
		return this.ticks(count, formatSpecifier);
	}-*/;

	/**
	 * Same as {@link #ticks(int)} but suitable for
	 * {@link LogScale#tickFormat(int, DatumFunction)}.
	 * 
	 * 
	 * @param count
	 *            the count to be passed to the underlying scale.
	 * @param formatSpecifier
	 *            the format argument to be passed to the underlying scale.
	 * @return the current axis
	 */
	public final native Axis ticks(int count,
			DatumFunction<String> formatSpecifier)/*-{
		return this.ticks(count, formatSpecifier);
	}-*/;

	/**
	 * Same as {@link #ticks(int)} but suitable for
	 * {@link TimeScale#ticks(Interval, int)}.
	 * 
	 * 
	 * @param interval
	 *            the time interval to be passed to the underlying scale.
	 * @param steps
	 *            the steps argument to be passed to the underlying scale.
	 * @return the current axis
	 */
	public final native Axis ticks(Interval interval, int steps)/*-{
		return this.ticks(interval, steps);
	}-*/;

	// ========== tick size =========
	/**
	 * Sets the major, minor and end to the given value.
	 * 
	 * @param majorMinorEnd
	 *            the new value
	 * @return the current axis
	 */
	public final native Axis tickSize(int majorMinorEnd)/*-{
		return this.tickSize(majorMinorEnd);
	}-*/;

	/**
	 * Sets the major, minor and end to the given values.
	 * 
	 * @param majorMinor
	 *            the new value for major and minor ticks
	 * @param end
	 *            the new end value
	 * @return the current axis
	 */
	public final native Axis tickSize(int majorMinor, int end)/*-{
		return this.tickSize(majorMinor, end);
	}-*/;

	/**
	 * Sets the major, minor and end to the given values.
	 * 
	 * @param majorMinor
	 *            the new value for major and minor ticks
	 * @param end
	 *            the new end value
	 * @return the current axis
	 */
	public final native Axis tickSize(int major, int minor, int end)/*-{
		return this.tickSize(major, minor, end);
	}-*/;

	// ========== tick subdivide =========

	/**
	 * Get the tick subdivision count, which defaults to zero.
	 * 
	 * @return the tick subdivision count
	 */
	public final native int tickSubdivide()/*-{
		return this.tickSubdivide();
	}-*/;

	/**
	 * Set the tick subdivision count and returns the axis.
	 * <p>
	 * Sets the number of uniform subdivision ticks to make between major tick
	 * marks. The specified count specifies the number of minor ticks, which is
	 * one less than the number of subdivisions.
	 * <p>
	 * For example, axis.tickSubdivide(1) produces one minor tick per major
	 * tick, thus cutting the space between each major tick in two. As another
	 * example, decimal subdivision is specified as axis.tickSubdivide(9).
	 * 
	 * @param count
	 *            the tick subdivision count
	 * @return the current axis
	 */
	public final native Axis tickSubdivide(int count)/*-{
		return this.tickSubdivide(count);
	}-*/;

	// ========== tick padding =========

	/**
	 * Returns the current padding which defaults to 3 pixels
	 * 
	 * @return the current padding
	 */
	public final native int tickPadding()/*-{
		return this.tickPadding();
	}-*/;

	/**
	 * Sets the padding to the specified value in pixels and returns the axis.
	 * <p>
	 * 
	 * @param padding
	 *            the padding in pixels
	 * @return the current axis
	 */
	public final native Axis tickPadding(int padding)/*-{
		return this.tickPadding(padding);
	}-*/;

	// ========== apply =========

	/**
	 * Apply the axis to a selection.
	 * <p>
	 * The selection must contain an SVG or G element.
	 * <p>
	 * 
	 * @param selection
	 *            the selection to apply the axis to
	 * @return the current axis.
	 */
	public final native Axis apply(Selection selection) /*-{
		return this(selection);
	}-*/;

	/**
	 * Apply the axis to a transition.
	 * <p>
	 * The transition must contain an SVG or G element.
	 * <p>
	 * 
	 * @param transition
	 *            the transition to apply the axis to
	 * @return the current axis.
	 */
	public final native Axis apply(Transition transition) /*-{
		return this(transition);
	}-*/;

	// ========== tickFormat =========

	/**
	 * Override the tick formatting for labels.
	 * 
	 * @param format
	 *            the tick value formatter for labels.
	 * @return the current axis.
	 */
	public final native Axis tickFormat(Formatter format) /*-{
		return this.tickFormat(format);
	}-*/;

	/**
	 * Set the function to be used to format tick values.
	 * <p>
	 * This method can be used for example to add prefix or suffix to the result
	 * of a {@link Formatter#format(double)} method.
	 * <p>
	 * Note: the given function of context argument will be null instance, and
	 * the index will be -1.
	 * <p>
	 * 
	 * @param formatFunction
	 *            the function converting each tick value to a String.
	 * @return the current {@link Axis}
	 */
	public final native Axis tickFormat(DatumFunction<String> formatFunction) /*-{
		return this
				.tickFormat(function(d) {
					return formatFunction.@com.github.gwtd3.api.functions.DatumFunction::apply(Lcom/google/gwt/dom/client/Element;Lcom/github/gwtd3/api/core/Value;I)(null,{datum:d},-1);
				});
	}-*/;

	/**
	 * Returns the current format function, which defaults to null. A null
	 * format indicates that the {@link Scale}'s default formatter should be
	 * used, which is generated by calling {@link Scale#tickFormat(int)}. In
	 * this case, the arguments specified by ticks are likewise passed to scale
	 * tickFormat.
	 * 
	 * @param format
	 *            the tick value formatter for labels.
	 * @return the current axis.
	 */
	public final native Formatter tickFormat() /*-{
		return this.tickFormat();
	}-*/;

	// ========== tickValues =========

	/**
	 * Return the currently-set tick values, which defaults to null.
	 * <p>
	 * 
	 * @return the currently-set tick values
	 */
	public final native Array<?> tickValues()/*-{
		return this.tickValues();
	}-*/;

	/**
	 * Specify the values to be used for ticks, rather than using the scale's
	 * automatic tick generator.
	 * <p>
	 * If values is null, clears any previously-set explicit tick values,
	 * reverting back to the scale's tick generator.
	 * <p>
	 * The explicit tick values take precedent over the tick arguments set by
	 * axis.ticks. However, any tick arguments will still be passed to the
	 * scale's tickFormat function if a tick format is not also set; thus, it
	 * may be valid to set both axis.ticks and axis.tickValues.
	 * <p>
	 * 
	 * @param values
	 *            the values to be used for ticks
	 * @return the current axis
	 */
	public final native Axis tickValues(JavaScriptObject values)/*-{
		return this.tickValues(values);
	}-*/;

	/**
	 * Alias for {@link #tickValues(JavaScriptObject)}.
	 * 
	 * @param values
	 *            the values
	 * @return the current axis
	 */
	public final Axis tickValues(double... values) {
		return this.tickValues(JsArrays.asJsArray(values));
	}

	/**
	 * * Alias for {@link #tickValues(JavaScriptObject)}.
	 * 
	 * @param values
	 *            the values
	 * @return the current axis
	 */
	public final Axis tickValues(String... values) {
		return this.tickValues(JsArrays.asJsArray(values));
	}

	/**
	 * Alias for {@link #tickValues(JavaScriptObject)}.
	 * 
	 * @param values
	 *            the values
	 * @return the current axis
	 */
	public final Axis tickValues(List<?> values) {
		return this.tickValues(JsArrays.asJsArray(values));
	}

}
