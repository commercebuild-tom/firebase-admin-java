/*
 * Copyright 2022 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.firebase.auth;

import com.google.firebase.auth.internal.GetAccountInfoResponse;

/**
 * Interface representing the common properties of a user-enrolled second factor.
 */
public class PhoneMultiFactorInfo extends MultiFactorInfo {

  /**
   * The phone number associated with a phone second factor.
   */
  private final String phoneNumber;

  private final String unobfuscatedPhoneNumber;

  public PhoneMultiFactorInfo(GetAccountInfoResponse.MultiFactorInfo response) {
    super(response);

    this.phoneNumber = response.getPhoneInfo();
    this.unobfuscatedPhoneNumber = response.getUnobfuscatedPhoneInfo();
  }

	@Override
	public MfaType getMfaType() {
		return MfaType.PHONE;
	}

	public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getUnobfuscatedPhoneNumber() {
    return unobfuscatedPhoneNumber;
  }
}
