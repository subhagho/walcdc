// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: walcdc.proto

package ai.sapper.walcdc.common.model;

public interface DataFieldChangeOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // required .ai_sapper_walcdc_common_model.FieldValue value = 1;
  /**
   * <code>required .ai_sapper_walcdc_common_model.FieldValue value = 1;</code>
   */
  boolean hasValue();
  /**
   * <code>required .ai_sapper_walcdc_common_model.FieldValue value = 1;</code>
   */
  ai.sapper.walcdc.common.model.FieldValue getValue();
  /**
   * <code>required .ai_sapper_walcdc_common_model.FieldValue value = 1;</code>
   */
  ai.sapper.walcdc.common.model.FieldValueOrBuilder getValueOrBuilder();

  // repeated .ai_sapper_walcdc_common_model.DataFieldChange.ChangeOp op = 2;
  /**
   * <code>repeated .ai_sapper_walcdc_common_model.DataFieldChange.ChangeOp op = 2;</code>
   */
  java.util.List<ai.sapper.walcdc.common.model.DataFieldChange.ChangeOp> getOpList();
  /**
   * <code>repeated .ai_sapper_walcdc_common_model.DataFieldChange.ChangeOp op = 2;</code>
   */
  int getOpCount();
  /**
   * <code>repeated .ai_sapper_walcdc_common_model.DataFieldChange.ChangeOp op = 2;</code>
   */
  ai.sapper.walcdc.common.model.DataFieldChange.ChangeOp getOp(int index);

  // optional .ai_sapper_walcdc_common_model.FieldValue original = 3;
  /**
   * <code>optional .ai_sapper_walcdc_common_model.FieldValue original = 3;</code>
   */
  boolean hasOriginal();
  /**
   * <code>optional .ai_sapper_walcdc_common_model.FieldValue original = 3;</code>
   */
  ai.sapper.walcdc.common.model.FieldValue getOriginal();
  /**
   * <code>optional .ai_sapper_walcdc_common_model.FieldValue original = 3;</code>
   */
  ai.sapper.walcdc.common.model.FieldValueOrBuilder getOriginalOrBuilder();
}
